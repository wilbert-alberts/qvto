/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxModuleHelper;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.osgi.util.NLS;

/**
 * The purpose of this class is facilitate deprecation of the legacy non-standard
 * <pre>import library [compilation-unit];</pre> statement in a backward compatible manner.
 * 
 * @author dvorak
 * @since 2.0
 */
class DeprecatedLibraryImportSupport {

	private QvtOperationalFileEnv fEnv;
	private MappingModuleCS fModuleCS;	
	private BlackboxModuleHelper fBlackboxHelper;
	
	DeprecatedLibraryImportSupport(QvtOperationalFileEnv env, MappingModuleCS moduleCS, BlackboxModuleHelper blackboxHelper) {
		if(env == null || moduleCS == null || blackboxHelper == null) {
			throw new IllegalArgumentException();
		}
		fEnv = env;
		fModuleCS = moduleCS;
		fBlackboxHelper = blackboxHelper;
		fBlackboxHelper.setContext(
				new ResolutionContextImpl(env.getFile()),
				new LoadContext(env.getEPackageRegistry()));
	}
	
	List<ModuleImport> analyzeLibraryImports() {
		if(fModuleCS.getImports().isEmpty()) {
			return Collections.emptyList();
		}
		
		List<ModuleImport> result = new LinkedList<ModuleImport>();
		ResolutionContext context = new ResolutionContextImpl(fEnv.getFile());
		Registry packageRegistry = fEnv.getFactory().getEPackageRegistry();
		LoadContext loadContext = new LoadContext(packageRegistry);
		fBlackboxHelper.setContext(context, loadContext);
		
		Set<String> perModuleProcessedIDs = new HashSet<String>(5);
		
		for (ImportCS libImport : fModuleCS.getImports()) {
			if (false == libImport instanceof LibraryImportCS) {
				continue;
			}
						
			PathNameCS impPath = libImport.getPathNameCS();
			String libId = QvtOperationalParserUtil.getStringRepresentation(impPath, "."); //$NON-NLS-1$

			// warn about specific library import deprecation
			fEnv.reportWarning(NLS.bind(ValidationMessages.DeprecatedLibraryImportSupportWarn0, new Object[] { libId }), impPath);
			
			if(perModuleProcessedIDs.contains(libId)) {
				fEnv.reportWarning(NLS.bind(ValidationMessages.DuplicateLibraryImport, new Object[] { libId }), impPath);
				continue;
			}

			final EList<String> unitQName = impPath.getSequenceOfNames();
			List<Module> bboxModules = fBlackboxHelper.getModules(unitQName);
			if(bboxModules == null) {
				if(fBlackboxHelper.notFound(unitQName)) {
					fEnv.reportError(NLS.bind(ValidationMessages.NoLibrary, new Object[] { libId }), impPath);
				} else if(fBlackboxHelper.loadFailed(unitQName)) {
					fEnv.reportError(wrappInSeeErrorLogMessage(NLS.bind(ValidationMessages.FailedToLoadLibrary, 
							new Object[] { libId })), impPath);				
				}
				continue;
			}
			// ad this library as newly processed for the given importing fModule
			assert perModuleProcessedIDs.contains(libId) == false; 
			perModuleProcessedIDs.add(libId);

			for (Module nextImportedModule : bboxModules) {
				QvtOperationalModuleEnv bboxModuleEnv = fBlackboxHelper.getModuleEnvironment(nextImportedModule);
				assert bboxModuleEnv != null;
				if(!fEnv.getSiblings().contains(bboxModuleEnv)) {
					fEnv.addSibling(bboxModuleEnv);
				}
				
				ModuleImport moduleImport = ExpressionsFactory.eINSTANCE.createModuleImport();
				moduleImport.setStartPosition(libImport.getStartOffset());
				moduleImport.setEndPosition(libImport.getEndOffset());
				moduleImport.setImportedModule(nextImportedModule);
				
				result.add(moduleImport);				
			}			
		}
		
		return result;		
	}
	
	private static String wrappInSeeErrorLogMessage(String message) {
		return NLS.bind(ValidationMessages.QvtOperationalVisitorCS_SeeErrorLogForDetails, message);
	}
}
