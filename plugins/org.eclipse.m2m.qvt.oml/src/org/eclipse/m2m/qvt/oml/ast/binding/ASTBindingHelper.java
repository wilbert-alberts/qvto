/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.ast.binding;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.utilities.ASTNode;

@SuppressWarnings("restriction")
public class ASTBindingHelper {
	
	public static void createEnvDefined2ImperativeOperationBinding(MappingMethodCS cstMethod, ImperativeOperation astImperativeOperation, EOperation envDefineOperation, Environment env) {
		ASTAdapter astAdapter = new ImperativeOperationASTAdapter(cstMethod, astImperativeOperation, envDefineOperation, (EcoreEnvironment)env);
		astImperativeOperation.eAdapters().add(astAdapter);	
		cstMethod.eAdapters().add(astAdapter);
		envDefineOperation.eAdapters().add(astAdapter);
	}
	
	public static ImperativeOperation resolveEnvOperationBinding(EOperation envDefinedOperation) {
		ASTAdapter adapter = getASTBinding(envDefinedOperation);
		if(adapter instanceof ImperativeOperationASTAdapter) {
			ImperativeOperationASTAdapter operationASTAdapter = (ImperativeOperationASTAdapter) adapter;
			return (ImperativeOperation)operationASTAdapter.getASTNode();
		}
		return null;
	}
	
	public static void createModuleBinding(MappingModuleCS cstModule, Module astModule, EcoreEnvironment env, CFile moduleFile) {
		ASTAdapter astAdapter = new ModuleASTAdapter(cstModule, astModule, env, moduleFile);
		astModule.eAdapters().add(astAdapter);	
		cstModule.eAdapters().add(astAdapter);		
	}
	
	public static CFile resolveModuleFile(MappingModuleCS cstModule) {
		ASTAdapter adapter = getASTBinding(cstModule);
		if (adapter instanceof ModuleASTAdapter) {
			ModuleASTAdapter moduleAdapter = (ModuleASTAdapter) adapter;
			return moduleAdapter.getModuleFile();			
		}
		return null;
	}

	public static void createCST2ASTBinding(CSTNode cstNode, ASTNode astNode) {
		createCST2ASTBinding(cstNode, astNode, null);
	}
	
	public static void createCST2ASTBinding(CSTNode cstNode, ASTNode astNode, Environment env) {
		ASTAdapter astAdapter = new ASTAdapter(cstNode, astNode, (EcoreEnvironment)env);
		astNode.eAdapters().add(astAdapter);	
		cstNode.eAdapters().add(astAdapter);
	}
	
	public static ASTNode resolveASTNode(CSTNode cstNode) {
		ASTAdapter adapter = getASTBinding(cstNode);
		return adapter != null ? adapter.getASTNode() : null;
	}
	
	public static final ASTNode resolveEnclosingASTNode(CSTNode cstNode) {
	    while (cstNode != null) {
	        ASTNode astNode = resolveASTNode(cstNode);
	        if (astNode != null) {
	            return astNode;
	        }
	        cstNode = (CSTNode) cstNode.eContainer();
	    };
	    return null;
	}
	
	public static CSTNode resolveCSTNode(ASTNode astNode) {
		ASTAdapter adapter = getASTBinding(astNode);
		return (adapter != null) ? adapter.getCSTNode() : null;
	}
	
	public static EcoreEnvironment resolveEnvironment(ASTNode astNode) {
		ASTNode processedNode = astNode;
		EcoreEnvironment env = localResolveEnvironment(processedNode);
		
		while(env == null && processedNode.eContainer() instanceof ASTNode) {
			processedNode = (ASTNode)processedNode.eContainer();
			env = localResolveEnvironment(processedNode);
		}
				
		return env;
	}
	
	private static EcoreEnvironment localResolveEnvironment(ASTNode astNode) {
		ASTAdapter adapter = getASTBinding(astNode);
		
		return (adapter != null) ? adapter.getEnvironment() : null;
	}
	
	public static ASTAdapter getASTBinding(EObject target) {
		for (Adapter nextAdapter : target.eAdapters()) {
			if(nextAdapter instanceof ASTAdapter) {
				return (ASTAdapter) nextAdapter;
			}
		}
		
		return null;
	}

	private static class ASTAdapter extends AdapterImpl {
		private ASTNode fAstNode;
		private CSTNode fCstNode;		
		private EcoreEnvironment fEnv;		
		
		
		ASTAdapter(CSTNode cstNode, ASTNode astNode, EcoreEnvironment env) {
			if(astNode == null || cstNode == null) {
				throw new IllegalArgumentException();
			}
			
			this.fAstNode = astNode;
			this.fCstNode = cstNode;
			this.fEnv = env;
		}
		
		public ASTNode getASTNode() {
			return fAstNode;
		}
		
		public CSTNode getCSTNode() {
			return fCstNode;
		}
		
		public EcoreEnvironment getEnvironment() {
			return fEnv;
		}
	}
	
	private static class ModuleASTAdapter extends ASTAdapter {
		private CFile file;
		
		protected ModuleASTAdapter(CSTNode cstNode, ASTNode astNode,
				EcoreEnvironment env, CFile moduleFile) {
			super(cstNode, astNode, env);
			
			this.file = moduleFile;
		}

		public CFile getModuleFile() {
			return file;
		}
	}	
	
	private static class ImperativeOperationASTAdapter extends ASTAdapter {
		private EOperation fEnvDefEOperation;
		
		ImperativeOperationASTAdapter(MappingMethodCS cstMethod, 
				ImperativeOperation astImperativeOperation, 
				EOperation envDefineOperation, EcoreEnvironment env) {
						
			super(cstMethod, astImperativeOperation, env);
						
			if(envDefineOperation == null) {
				throw new IllegalArgumentException();
			}
			this.fEnvDefEOperation = envDefineOperation;
		}
		
		public EOperation getEnvDefinedOperation() {
			return fEnvDefEOperation;
		}
	}
}
