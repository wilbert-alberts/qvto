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
package org.eclipse.m2m.internal.qvt.oml.ast.binding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.util.LineNumberProvider;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.utilities.ASTNode;

public class ASTBindingHelper {
	
	public static <T> T getAST(CSTNode node, Class<T> type) {
		if(type == null) {
			throw new IllegalArgumentException();
		}
		
		Object astObj = node.getAst();
		return (type.isInstance(astObj)) ? type.cast(astObj) : null;
	}	
	
	public static void createModuleSourceBinding(EObject target, URI sourceURI, LineNumberProvider lineNumberProvider) {
		target.eAdapters().add(new ModuleSourceAdapter(sourceURI, lineNumberProvider));
	}
				
	public static IModuleSourceInfo getModuleSourceBinding(Module astModule) {
		return (IModuleSourceInfo)EcoreUtil.getExistingAdapter(astModule, ModuleSourceAdapter.class);
	}
		
	public static void createModuleBinding(MappingModuleCS cstModule, Module astModule, EcoreEnvironment env, CFile moduleFile) {
		ASTAdapter<ASTNode> astAdapter = new ModuleASTAdapter(cstModule, astModule, env, moduleFile);
		astModule.eAdapters().add(astAdapter);	
		cstModule.eAdapters().add(astAdapter);		
	}
	
    public static CFile resolveModuleFile(EObject cstModule) {
        ModuleASTAdapter moduleASTAdapter = getModuleASTAdapter(cstModule);
        if (moduleASTAdapter != null) {
            return moduleASTAdapter.getModuleFile();           
        }
        return null;
    }

    public static EcoreEnvironment resolveEnvironment(MappingModuleCS cstModule) {
        ModuleASTAdapter moduleASTAdapter = getModuleASTAdapter(cstModule);
        if (moduleASTAdapter != null) {
            return moduleASTAdapter.getEnvironment();           
        }
        return null;
    }

	public static void createCST2ASTBinding(CSTNode cstNode, ASTNode astNode) {
		createCST2ASTBinding(cstNode, astNode, true, null);
	}
	
	public static void createCST2ASTBinding(CSTNode cstNode, ASTNode astNode, Environment env) {
		createCST2ASTBinding(cstNode, astNode, true, env);
	}
	
	@SuppressWarnings("unchecked")
	public static void createCST2ASTBinding(CSTNode cstNode, ASTNode astNode, boolean isBidirectional, Environment env) {
		ASTAdapter astAdapter = new ASTAdapter(cstNode, astNode, (EcoreEnvironment)env);
		if(isBidirectional) {
			astNode.eAdapters().add(astAdapter);
		}
		cstNode.eAdapters().add(astAdapter);
	}
	
	public static <AST> void createCST2ASTBindingUnidirectional(CSTNode cstNode, AST astNode) {
		ASTAdapter<AST> astAdapter = new ASTAdapter<AST>(cstNode, astNode, null);
		cstNode.eAdapters().add(astAdapter);
	}	

	public static ASTNode resolveASTNode(CSTNode cstNode) {
		return resolveASTNode(cstNode, ASTNode.class);
	}
	
	public static <AST> AST resolveASTNode(CSTNode cstNode, Class<AST> astType) {
		return firstASTNodeOfType(getASTBindings(cstNode), astType);
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
	
	public static <AST extends EObject, T extends CSTNode> T resolveCSTNode(AST astNode, Class<T> cstType) {
		return firstCSTNodeOfType(getASTBindings(astNode), cstType);
	}
	
	public static CSTNode resolveCSTNode(ASTNode astNode) {
		return resolveCSTNode(astNode, CSTNode.class);
	}
	
	public static EcoreEnvironment resolveEnvironment(ASTNode astNode) {
		EObject processedNode = astNode;
		EcoreEnvironment env = localResolveEnvironment(astNode);
		
		while(env == null && processedNode.eContainer() != null) {
			processedNode = processedNode.eContainer();
			if (processedNode instanceof ASTNode) {
				env = localResolveEnvironment((ASTNode) processedNode);
			}
		}
				
		return env;
	}
	
	private static <A> EcoreEnvironment localResolveEnvironment(ASTNode astNode) {
		List<ASTAdapter<A>> adapters = getASTBindings(astNode);
		for (ASTAdapter<A> nextAdapter : adapters) {
			if(nextAdapter.getEnvironment() != null) {
				return nextAdapter.getEnvironment();
			}
		}
		return null;
	}
	
	private static <A, T extends A> T firstASTNodeOfType(List<ASTAdapter<A>> objects, Class<T> type) {
		for (ASTAdapter<A> nextAST : objects) {
			if(type.isInstance(nextAST.getASTNode())) {
				return type.cast(nextAST.getASTNode());
			}
		}
		return null;
	}
	
	private static <A, T extends CSTNode> T firstCSTNodeOfType(List<ASTAdapter<A>> objects, Class<T> type) {
		for (ASTAdapter<A> nextCST : objects) {
			if(type.isInstance(nextCST.getCSTNode())) {
				return type.cast(nextCST.getCSTNode());
			}
		}
		return null;
	}
	
	private static ModuleASTAdapter getModuleASTAdapter(EObject target) {
        List<ModuleASTAdapter> adapters = getASTBindings(target, ModuleASTAdapter.class);
        if (!adapters.isEmpty()) {
            ModuleASTAdapter moduleAdapter = (ModuleASTAdapter) adapters.get(0);
            return moduleAdapter;
        }
        return null;
	}
	
	static <AST> List<ASTAdapter<AST>> getASTBindings(EObject target) {
		return getASTBindings(target, ASTAdapter.class);
	}
	
	static <A, T extends ASTAdapter<A>> List<T> getASTBindings(EObject target, Class<T> adapterType) {
		List<T> result = Collections.emptyList();
		
		for (Adapter nextAdapter : target.eAdapters()) {
			if(adapterType.isInstance(nextAdapter)) {
				if(result.isEmpty()) {
					result = new ArrayList<T>(3);
				}
				
				result.add(adapterType.cast(nextAdapter));
			}
		}

		return result;
	}

	private static class ASTAdapter<A> extends AdapterImpl {
		private A fAstNode;
		private CSTNode fCstNode;		
		private EcoreEnvironment fEnv;		
		
		
		ASTAdapter(CSTNode cstNode, A astNode, EcoreEnvironment env) {
			if(astNode == null || cstNode == null) {
				throw new IllegalArgumentException();
			}
			
			this.fAstNode = astNode;
			this.fCstNode = cstNode;
			this.fEnv = env;
		}
		
		public A getASTNode() {
			return fAstNode;
		}
		
		public CSTNode getCSTNode() {
			return fCstNode;
		}
		
		public EcoreEnvironment getEnvironment() {
			return fEnv;
		}		
	}
	
	private static class ModuleASTAdapter extends ASTAdapter<ASTNode> {
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

	private static class ModuleSourceAdapter extends AdapterImpl implements IModuleSourceInfo {
		private URI fSourceURI;
		private LineNumberProvider fLineNumProvider;
		
		protected ModuleSourceAdapter(URI sourceURI, LineNumberProvider lineNumberProvider) {
			if(sourceURI == null || lineNumberProvider == null) {
				throw new IllegalArgumentException();
			}
			fSourceURI = sourceURI;
			fLineNumProvider = lineNumberProvider;
		}
		
		public URI getSourceURI() {
			return fSourceURI;
		}
				
		public LineNumberProvider getLineNumberProvider() {
			return fLineNumProvider; 
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == ModuleSourceAdapter.class;
		}
	}	
}
