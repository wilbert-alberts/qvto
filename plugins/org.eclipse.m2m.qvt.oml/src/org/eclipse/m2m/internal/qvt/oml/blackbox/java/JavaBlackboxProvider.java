/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractBlackboxProvider;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxException;
import org.eclipse.m2m.internal.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.internal.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;


public class JavaBlackboxProvider extends AbstractBlackboxProvider {
	
	private static final String PROVIDER_ID = "Java"; //$NON-NLS-1$
	
	private static final String EXTENSION_POINT = "javaBlackboxUnits"; //$NON-NLS-1$
	
	private static final String CLASS_NAME_SEPARATOR = "."; //$NON-NLS-1$
	
	private static final String UNIT_ELEM = "unit";	//$NON-NLS-1$
	private static final String LIBRARY_ELEM = "library"; //$NON-NLS-1$	
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$
	private static final String NAME_ATTR = "name";	//$NON-NLS-1$
	private static final String NAMESPACE_ATTR = "namespace"; //$NON-NLS-1$
	private static final String DESC_ATTR = "description"; //$NON-NLS-1$

	private static final String METAMODEL_ELEM = "metamodel"; //$NON-NLS-1$
	private static final String NSURI_ATTR = "nsURI"; //$NON-NLS-1$	
		
	private final Map<String, Descriptor> fDescriptorMap;
	
	public JavaBlackboxProvider() {
		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			fDescriptorMap = readDescriptors();
		} else {
			fDescriptorMap = Collections.emptyMap();
		}
	}

	@Override
	public AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext) {
		// TODO - Should we necessarily be available in all contexts ? 
		return fDescriptorMap.get(qualifiedName);
	}
	
	@Override
	protected String getProviderID() {
		return PROVIDER_ID;
	}	

	@Override
	public List<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext resolutionContext) {
		// TODO - Should we necessarily be available in all contexts ?
		ArrayList<AbstractCompilationUnitDescriptor> result = new ArrayList<AbstractCompilationUnitDescriptor>(fDescriptorMap.size());
		result.addAll(fDescriptorMap.values());
		return Collections.unmodifiableList(result);
	}

	@Override
	public CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException {
		if(descriptor instanceof Descriptor == false) {
			throw new IllegalArgumentException("Invalid descriptor"); //$NON-NLS-1$
		}

		Descriptor libDescriptor = (Descriptor) descriptor;
		JavaModuleLoader javaModuleLoader = createJavaModuleLoader();

		BasicDiagnostic errors = null;
		List<QvtOperationalModuleEnv> loadedModules = new LinkedList<QvtOperationalModuleEnv>();
		
		for (ModuleHandle nextModuleHandle : libDescriptor.fModules) {
			Diagnostic diagnostic = javaModuleLoader.loadModule(nextModuleHandle);
			
			if(DiagnosticUtil.isSuccess(diagnostic)) {
				QvtOperationalModuleEnv nextModuleEnv = javaModuleLoader.getLoadedModule();
				nextModuleEnv.getTypeResolver().getResource().setURI(descriptor.getURI());
				loadedModules.add(nextModuleEnv);
				
				if(diagnostic.getSeverity() != Diagnostic.OK) {
					QvtPlugin.logDiagnostic(diagnostic);
				}
			} else {
				if(errors == null) {
					String message = NLS.bind(JavaBlackboxMessages.BlackboxUnitLoadFailed, descriptor.getQualifiedName());
					errors = DiagnosticUtil.createErrorDiagnostic(message);
				}
				
				errors.add(diagnostic);
			}
		}
		
		if(errors != null) {
			assert errors.getSeverity() == Diagnostic.ERROR;
			throw new BlackboxException(errors);
		}

		return createCompilationUnit(loadedModules);
	}

	private JavaModuleLoader createJavaModuleLoader() {
		return new JavaModuleLoader() {
			JavaMethodHandlerFactory handlerFactory;		
			@Override
			protected void loadModule(QvtOperationalModuleEnv moduleEnv, final Class<?> javaModuleClass) {
				handlerFactory = new JavaMethodHandlerFactory(moduleEnv.getOCLStandardLibrary());
				
				Module module = moduleEnv.getModuleContextType();
				// FIXME - workaround to make Environment available with the module for
				// non-transformation execution context
				ASTBindingHelper.createCST2ASTBinding(CSTFactory.eINSTANCE.createLibraryCS(), module, moduleEnv);		

				setInstanceAdapterFactory(module, createInstanceAdapterFactory(javaModuleClass));
			}
			
			@Override
			protected void loadOperation(EOperation operation, Method javaOperation) {
				setOperationHandler(operation, handlerFactory.createHandler(javaOperation), true);
			}
		};
	}

	static InstanceAdapterFactory createInstanceAdapterFactory(final Class<?> javaModuleClass) {
		return new InstanceAdapterFactory() {												
			public Object createAdapter(EObject moduleInstance) {
				try {
					return javaModuleClass.newInstance();
				} catch (InstantiationException e) {
					// FIXME - choose a better exception
					throw new IllegalArgumentException("Illegal adapter instance", e);								 //$NON-NLS-1$
				} catch (IllegalAccessException e) {
					// FIXME - choose a better exception
					throw new IllegalArgumentException("Illegal adapter instance", e); //$NON-NLS-1$
				}
			}
		};
	}
		
    private Map<String, Descriptor> readDescriptors() {
    	Map<String, Descriptor> providers = new HashMap<String, Descriptor>();
        
        IConfigurationElement[] configs = Platform.getExtensionRegistry()
        		.getConfigurationElementsFor(QvtPlugin.ID, EXTENSION_POINT);

        for (IConfigurationElement element : configs) {
            try {
            	Descriptor descriptor = createDescriptor(element);
        		String id = descriptor.getQualifiedName();            	
            	if(!providers.containsKey(id)) {
					providers.put(id, descriptor);
            	} else {
            		String message = NLS.bind(JavaBlackboxMessages.UnitAlreadyRegisteredContributionIgnored, id, descriptor.getContributorId());
					QvtPlugin.error(message);
            	}
            } catch (IllegalArgumentException e) {
            	QvtPlugin.error("Failed to read java black-box definition: " + e.getMessage()); //$NON-NLS-1$
            }
        }

        return providers;
    }
        
	private Descriptor createDescriptor(IConfigurationElement configurationElement) throws IllegalArgumentException {
		if(UNIT_ELEM.equals(configurationElement.getName())) {
			String name = configurationElement.getAttribute(NAME_ATTR);
			String namespace = configurationElement.getAttribute(NAMESPACE_ATTR);		
			if(namespace == null) {
				configurationElement.getContributor().getName();
			}
			
			String description = configurationElement.getAttribute(DESC_ATTR);		
			String qualifiedName = namespace + CLASS_NAME_SEPARATOR + name;
			return new Descriptor(configurationElement, qualifiedName, description);
		} else if(LIBRARY_ELEM.equals(configurationElement.getName())) {
			return new Descriptor(configurationElement, deriveQualifiedNameFromSimpleDefinition(configurationElement), null);
		}
		
		throw new IllegalArgumentException("Unsupported configuration element " + configurationElement); //$NON-NLS-1$		
	}
    		
	private static String getPackageNameFromJavaClass(String className) {
		int lastSeparatorPos = className.lastIndexOf(CLASS_NAME_SEPARATOR);
		if(lastSeparatorPos < 0) {
			return null;
		}

		return className.substring(0, lastSeparatorPos);
	}
	
	private static String deriveQualifiedNameFromSimpleDefinition(IConfigurationElement moduleElement) {
		String className = moduleElement.getAttribute(CLASS_ATTR);		
		String name = moduleElement.getAttribute(NAME_ATTR);				
		if(name == null) {
			return className;
		}
		// name overridden in descriptor
		String packageName = getPackageNameFromJavaClass(className);
		if(packageName == null) {
			return name; // default package
		}
		return packageName + CLASS_NAME_SEPARATOR + name;
	}	
	
	private class Descriptor extends AbstractCompilationUnitDescriptor {		
		private List<ModuleHandle> fModules = Collections.emptyList();
		private String fContributingBundleId; 

		Descriptor(IConfigurationElement configurationElement, String unitQualifiedName, String description) {
			super(JavaBlackboxProvider.this, unitQualifiedName, 
					//configurationElement.getContributor().getName(), 
					unitQualifiedName);
			fContributingBundleId = configurationElement.getContributor().getName();
			
			if(configurationElement.getName().equals(LIBRARY_ELEM)) {
				addModuleHandle(configurationElement);				
			} else {
				IConfigurationElement[] libraries = configurationElement.getChildren(LIBRARY_ELEM);			
				for (IConfigurationElement moduleElement : libraries) {
					addModuleHandle(moduleElement);
				}
			}
		}

		String getContributorId() {
			return fContributingBundleId;
		}
		
		private void addModuleHandle(IConfigurationElement moduleElement) {
			if(fModules.isEmpty()) {
				fModules = new LinkedList<ModuleHandle>();
			}
			
			String bundleId = moduleElement.getContributor().getName();
			String className = moduleElement.getAttribute(CLASS_ATTR);
			String moduleName = moduleElement.getAttribute(NAME_ATTR);
			if(moduleName == null) {
				// derive the name from the java class name
				moduleName = getSimpleNameFromJavaClass(className);
			}
			
			ModuleHandle moduleHandle = new BundleModuleHandle(bundleId, className, moduleName, readUsedPackagesNsURIs(moduleElement));
			fModules.add(moduleHandle);
		}
		
		private List<String> readUsedPackagesNsURIs(IConfigurationElement moduleConfigElement) {
			ArrayList<String> uris = new ArrayList<String>(3);
			for (IConfigurationElement nextElement : moduleConfigElement.getChildren(METAMODEL_ELEM)) {
				String nsURI = nextElement.getAttribute(NSURI_ATTR);
				if(nsURI != null) {
					uris.add(nsURI);
				}
			}
			
			return uris;
		}
		
		private String getSimpleNameFromJavaClass(String className) {
			int lastSeparatorPos = className.lastIndexOf(CLASS_NAME_SEPARATOR);
			if(lastSeparatorPos < 0) {
				return className;
			}

			return className.substring(lastSeparatorPos + 1);
		}		
	}

}
