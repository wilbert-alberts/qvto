/*******************************************************************************
 * Copyright (c) 2009, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.EmfStandaloneMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;

public class CompilerUtils {

	public static Diagnostic createProblemDiagnostic(URI uri, QvtMessage problem) {
		int qvtSeverity = problem.getSeverity();
		int diagnosticSeverity = qvtSeverity == QvtMessage.SEVERITY_ERROR ? Diagnostic.ERROR
				: Diagnostic.WARNING;

		String source = uri.toString();
		String message = problem.getMessage();
		// add the line number info if any
		if (problem.getLineNum() >= 0) {
			message = message + " (at:" + problem.getLineNum() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ 
		}

		return new BasicDiagnostic(diagnosticSeverity, source, 0, message, null);
	}

	public static Diagnostic createUnitProblemDiagnostic(CompiledUnit unit) {
		if(unit.getProblems().isEmpty()) {
			return Diagnostic.OK_INSTANCE;
		}
		
		URI uri = unit.getURI();
		
		List<QvtMessage> problems = unit.getProblems();
		List<Diagnostic> children = new ArrayList<Diagnostic>(problems.size());
		int errorCount = 0;
		int warnCount = 0;
		
		for (QvtMessage problem : unit.getProblems()) {
			if(problem.getSeverity() == QvtMessage.SEVERITY_ERROR) {
				errorCount++;
			} else if(problem.getSeverity() == QvtMessage.SEVERITY_WARNING) {
				warnCount++;
			}			
			children.add(createProblemDiagnostic(uri, problem));
		}

		String mainMessage = NLS.bind(CompilerMessages.unitDiagnostic, errorCount, warnCount);
		BasicDiagnostic unitDiagnostic = new BasicDiagnostic(uri.toString(), 0, children, mainMessage, null);
		return unitDiagnostic;
	}
	
	static Monitor createMonitor(Monitor monitor, int ticks) {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			return Eclipse.createMonitor(monitor, ticks);			
		}
		
		return monitor;
	}
	
	static void throwOperationCanceled() throws RuntimeException {
		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			Eclipse.throwOperationCanceled();
		} else {
			throw new RuntimeException("Operation canceled"); //$NON-NLS-1$
		}
	}
	
	static Monitor createNullMonitor() {
		return new BasicMonitor();
	}
	
    static EPackage.Registry getEPackageRegistry(URI context, IMetamodelRegistryProvider metamodelRegistryProvider) {
    	MetamodelRegistry metamodelRegistry = metamodelRegistryProvider.getRegistry(new CResourceRepositoryContext(context));
    	EPackage.Registry packageRegistry;

    	if(metamodelRegistry != null) {
    		packageRegistry = metamodelRegistry.toEPackageRegistry();
    	} else {
    		packageRegistry = new EPackageRegistryImpl();
    	}

    	return packageRegistry;
    }
	
    static ResourceSet createResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new EPackageRegistryBasedURIResourceMap(resourceSet.getURIConverter()));
		return resourceSet;
    }
    
    public static QVTOCompiler createCompiler(UnitResolver importResolver) {
    	// FIXME - eliminate eclipse dependency here, the call should be should be responsible
    	// for setting this up, as different domains have different requirements,
    	// like editor, builders etc.
    	if(EMFPlugin.IS_ECLIPSE_RUNNING && EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE) {
    		return Eclipse.createCompiler(importResolver);
    	}
    	
    	return QVTOCompiler.createCompiler(importResolver, EPackage.Registry.INSTANCE);
    }
    
    static class Eclipse {

        static QVTOCompiler createCompiler(UnitResolver importResolver) {
        	return new QVTOCompiler(importResolver, new WorkspaceMetamodelRegistryProvider(createResourceSet()));
        }    	

    	static Monitor createMonitor(Monitor monitor, int ticks) {
			if (monitor instanceof IProgressMonitor) {
				return new BasicMonitor.EclipseSubProgress((IProgressMonitor) monitor, ticks);
			} else {
				return new BasicMonitor.EclipseSubProgress(BasicMonitor.toIProgressMonitor(monitor), ticks);
			}
    	}
    	
    	static void throwOperationCanceled() throws RuntimeException {
    		throw new OperationCanceledException();
    	}

		static WorkspaceMetamodelRegistryProvider createMetamodelRegistryProvider(ResourceSet metamodelResourceSet) {
			return metamodelResourceSet != null ?
						new WorkspaceMetamodelRegistryProvider(metamodelResourceSet) :
						new WorkspaceMetamodelRegistryProvider();
		}

		static WorkspaceMetamodelRegistryProvider createMetamodelRegistryProvider(final EPackage.Registry packageRegistry, ResourceSet metamodelResourceSet) {
			return new WorkspaceMetamodelRegistryProvider(metamodelResourceSet) {
				IMetamodelProvider registry = new EmfStandaloneMetamodelProvider(packageRegistry);
				@Override
				public MetamodelRegistry getRegistry(IRepositoryContext context) {
					MetamodelRegistry result = super.getRegistry(context);
					if(result == MetamodelRegistry.getInstance()) {
						// FIXME - get rid of this hack by providing
						// a protected method WorkspaceProvider::getDelegateRegistry();
						// which by default returns MetamodelRegistry.getInstance()
						result = new MetamodelRegistry(registry);
					} else if(result != null) {
						MetamodelRegistry customRegistry = new MetamodelRegistry(registry);					
						customRegistry.merge(result);
						result = customRegistry;
					}
					return result;
				}
			};
		}    	
    }
}
