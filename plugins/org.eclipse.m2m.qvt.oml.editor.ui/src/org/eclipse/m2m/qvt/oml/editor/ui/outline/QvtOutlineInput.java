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
package org.eclipse.m2m.qvt.oml.editor.ui.outline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.qvt.oml.internal.cst.ImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.LibraryImportCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.RenameCS;
import org.eclipse.m2m.qvt.oml.ocl.OclQvtoPlugin;
import org.eclipse.m2m.qvt.oml.ocl.transformations.Library;
import org.eclipse.m2m.qvt.oml.ocl.transformations.LibraryCreationException;
import org.eclipse.m2m.qvt.oml.ocl.transformations.LibraryOperation;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

public class QvtOutlineInput {

	public QvtOutlineInput() {
		this(null);
	}

	public QvtOutlineInput(ParsedModuleCS parsedModuleCS) {
		myModule = parsedModuleCS;
	}
	
	public void mappingModuleUpdated(ParsedModuleCS parsedModuleCS) {
		myModule = parsedModuleCS;
		myModuleNode.setIdentity(getModuleNodeIdentity());
	}

	public Object[] getChildren() {
		if (myChildren == null) {
			myModuleNode = new ModuleNode(getModuleNodeIdentity());
			myChildren = new Object[] {
					new ImportsNode(), new MetamodelsNode(), new RenamesNode(), 
	                new PropertiesNode(), myModuleNode
			};
		}
		return myChildren;
	}

	private String getModuleNodeIdentity() {
		return myModule != null ? QvtOutlineLabelProvider.getMappingModuleLabel(myModule.getModuleCS()) : ""; //$NON-NLS-1$
	}
	
	private abstract class ModuleDependentNode extends OutlineNode {

		protected ModuleDependentNode(String identity, Object parent, int type) {
			super(identity, parent, type);
		}
		
		protected ModuleDependentNode(String identity, Object parent, int type, CSTNode syntaxElement) {
			super(identity, parent, type, syntaxElement);
		}
		
		@Override
		public final List<OutlineNode> getChildren() {
			if (myModule == null) {
				return Collections.emptyList();
			}
			return doGetChildren();
		}
		
		protected abstract List<OutlineNode> doGetChildren();
		
	}

	private final class ModuleNode extends ModuleDependentNode {

		public ModuleNode(String identity) {
			super(identity, QvtOutlineInput.this, QvtOutlineNodeType.MAPPING_MODULE);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();

			for (MappingMethodCS method : myModule.getModuleCS().getMethods()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getMappingRuleLabel(method), this,
						QvtOutlineNodeType.MAPPING_RULE, method);
				result.add(childNode);
			}

			return result;
		}

	}

	private final class ImportsNode extends ModuleDependentNode {

		public ImportsNode() {
			super(QvtOutlineLabelProvider.IMPORTS_NODE, QvtOutlineInput.this, QvtOutlineNodeType.IMPORTED_MODULES);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			for (ImportCS imp : myModule.getModuleCS().getImports()) {
				PathNameCS importPath = imp.getPathNameCS();
				if (imp instanceof LibraryImportCS) {
					LibraryNode childNode = new LibraryNode(QvtOutlineLabelProvider.getImportLabel(importPath), this,
							QvtOutlineNodeType.MAPPING_MODULE, importPath);
					result.add(childNode);
				}
				else if (myModule.getParsedImport(importPath) != null) {
					MappingModuleCS moduleCS = myModule.getParsedImport(importPath).getModuleCS();
					OutlineNode childNode = new ImportedModuleNode(QvtOutlineLabelProvider.getImportLabel(importPath),
							moduleCS, this, QvtOutlineNodeType.MAPPING_MODULE, importPath);
					result.add(childNode);
				}
			}

			return result;
		}

	}

	private final class MetamodelsNode extends ModuleDependentNode {

		public MetamodelsNode() {
			super(QvtOutlineLabelProvider.METAMODELS_NODE, QvtOutlineInput.this, QvtOutlineNodeType.IMPORTED_METAMODELS);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();

			for (ModelTypeCS modelTypeCS : myModule.getModuleCS().getMetamodels()) {
		    	if (modelTypeCS == null || modelTypeCS.getPackageRefs().isEmpty()) {
		    		continue;
		    	}
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getMetamodelLabel(modelTypeCS), this,
						QvtOutlineNodeType.METAMODEL, modelTypeCS);
				result.add(childNode);
			}

			return result;
		}

	}

	private final class RenamesNode extends ModuleDependentNode {

		public RenamesNode() {
			super(QvtOutlineLabelProvider.RENAMES_NODE, QvtOutlineInput.this, QvtOutlineNodeType.RENAMES);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();

			for (RenameCS rename : myModule.getModuleCS().getRenamings()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getRenameLabel(rename), this,
						QvtOutlineNodeType.RENAME, rename);
				result.add(childNode);
			}

			return result;
		}

	}

	private final class PropertiesNode extends ModuleDependentNode {

		public PropertiesNode() {
			super(QvtOutlineLabelProvider.PROPERTIES_NODE, QvtOutlineInput.this, QvtOutlineNodeType.PROPERTIES);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();

			for (ModulePropertyCS prop : myModule.getModuleCS().getProperties()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getPropertyLabel(prop), this,
						QvtOutlineNodeType.PROPERTY, prop);
				result.add(childNode);
			}

			return result;
		}

	}

	private static final class LibraryNode extends OutlineNode {
		public LibraryNode(final String identity, final OutlineNode parent, int type, CSTNode syntaxElement) {
			super(identity, parent, type, syntaxElement);
		}

		@Override
		public List<OutlineNode> getChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			String libId = getIdentity();
			Library lib = OclQvtoPlugin.getDefault().getLibrariesRegistry().getLibrary(libId);

			if (lib != null) {
				try {
					for (Iterator<?> it = lib.getLibraryOperations().iterator(); it.hasNext();) {
						LibraryOperation libOp = (LibraryOperation) it.next();
						String label = QvtOutlineLabelProvider.getMappingDeclarationAsString(libOp.getName(),
								"", Collections.<String>emptyList()); //$NON-NLS-1$
						OutlineNode childNode = new OutlineNode(label, this, QvtOutlineNodeType.MAPPING_RULE);
						result.add(childNode);
					}
				} catch (LibraryCreationException e) {
					Logger.getLogger().log(Logger.SEVERE, "Exception while loading library", e); //$NON-NLS-1$
				}
			}

			return result;
		}
	}

	private static final class ImportedModuleNode extends OutlineNode {

		public ImportedModuleNode(final String identity, MappingModuleCS importedModule, final OutlineNode parent, int type,
				CSTNode syntaxElement) {
			super(identity, parent, type, syntaxElement);
			myImportedModule = importedModule;
		}

		@Override
		public List<OutlineNode> getChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			if (myImportedModule != null) {
				for (MappingMethodCS operationCS : myImportedModule.getMethods()) {
					MappingDeclarationCS declaration = operationCS.getMappingDeclarationCS();
					if (declaration == null) {
						continue;
					}
					String label = QvtOutlineLabelProvider.getMappingRuleLabel(operationCS);
					OutlineNode childNode = new OutlineNode(label, this, QvtOutlineNodeType.MAPPING_RULE);
					result.add(childNode);
				}
			}
			return result;
		}

		private final MappingModuleCS myImportedModule;

	}

	private ParsedModuleCS myModule;
	
	private Object[] myChildren;
	
	private ModuleNode myModuleNode;
	
}
