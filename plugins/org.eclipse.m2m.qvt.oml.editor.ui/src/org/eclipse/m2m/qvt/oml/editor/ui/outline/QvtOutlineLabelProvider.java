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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingQueryCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModelTypeCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ModulePropertyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.RenameCS;
import org.eclipse.m2m.qvt.oml.ui.QvtPluginImages;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.swt.graphics.Image;

public class QvtOutlineLabelProvider implements ILabelProvider {
	
	public static final String RENAMES_NODE = "renamings"; //$NON-NLS-1$
    public static final String METAMODELS_NODE = "metamodels"; //$NON-NLS-1$
    public static final String IMPORTS_NODE = "imports"; //$NON-NLS-1$
    public static final String PROPERTIES_NODE = "properties"; //$NON-NLS-1$
    public static final String LIBRARY_NODE = "library"; //$NON-NLS-1$
    
	public QvtOutlineLabelProvider() {
	}
	
    public Image getImage(Object element) {
    	OutlineNode node = (OutlineNode)element;
    	switch (node.getType()) {
			case QvtOutlineNodeType.IMPORTED_METAMODELS:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.IMPORTED_MODULES:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.METAMODEL:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_EXTERNAL_ARCHIVE);
			case QvtOutlineNodeType.MAPPING_MODULE:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);
			case QvtOutlineNodeType.RENAMES:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.RENAME:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PUBLIC);
			case QvtOutlineNodeType.PROPERTIES:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.PROPERTY:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_FIELD_PUBLIC);
			case QvtOutlineNodeType.MAPPING_RULE: {
				if (node.getSyntaxElement() instanceof MappingQueryCS) {
					return QvtPluginImages.getInstance().getImage(QvtPluginImages.QUERY);
				}
				return QvtPluginImages.getInstance().getImage(QvtPluginImages.MAPPING);
			}
			case QvtOutlineNodeType.IMPORTED_LIBRARY:
				return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_IMPCONT);
			default:
				return null;
		}
    }

    public String getText(final Object element) {
    	return element.toString();
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }
    
    
    
    public static String getMappingModuleLabel(final MappingModuleCS m) {
    	return (m.getHeaderCS() == null || m.getHeaderCS().getPathNameCS() == null) ? "" : //$NON-NLS-1$
    		getImportLabel(m.getHeaderCS().getPathNameCS()); 
    }

    public static String getMappingRuleLabel(final MappingMethodCS r) {
    	return getMappingDeclarationAsString(r.getMappingDeclarationCS());
    }

    public static String getRenameLabel(final RenameCS r) {
    	return r.getOriginalName().getStringSymbol() + " := " + r.getSimpleNameCS().getValue(); //$NON-NLS-1$
    }
    
    public static String getPropertyLabel(final ModulePropertyCS prop) {
    	return prop.getSimpleNameCS().getValue();
    }

    public static String getImportLabel(final PathNameCS path) {
        StringBuffer buffer = null;
        for (String part : path.getSequenceOfNames()) {
			if (buffer != null) {
                buffer.append("."); //$NON-NLS-1$
			} else {
                buffer = new StringBuffer();
			}
            buffer.append(part);
		}
		return buffer == null ? "" : buffer.toString(); //$NON-NLS-1$
    }

    public static String getMetamodelLabel(final ModelTypeCS modelTypeCS) {
    	StringLiteralExpCS uriCS = modelTypeCS.getPackageRefs().get(0).getUriCS();
    	if (uriCS == null) {
    		return ""; //$NON-NLS-1$
    	}
    	return uriCS.getStringSymbol();
    }
    
    private static String getMappingDeclarationAsString(final MappingDeclarationCS decl) {
    	if (decl == null) {
    		return ""; //$NON-NLS-1$
    	}
    	List<String> listParam = new ArrayList<String>();
    	for (ParameterDeclarationCS param : decl.getParameters()) {
    		listParam.add(getParameterDeclarationAsString(param));
    	}
    	String context = getTypeAsString(decl.getContextType());
		return getMappingDeclarationAsString(decl.getSimpleNameCS().getValue(), context, listParam);
    }


    public static String getMappingDeclarationAsString(String name, String contextType, List<String> params){
    	StringBuffer result = new StringBuffer (contextType);
    	result.append("::"); //$NON-NLS-1$
    	result.append(name);
    	result.append("("); //$NON-NLS-1$
    	for (Iterator<String> it = params.iterator(); it.hasNext(); ){
    		result.append(it.next());
    		if (it.hasNext()) {
    			result.append(", "); //$NON-NLS-1$
    		}
    	}
    	result.append(")"); //$NON-NLS-1$
    	return result.toString();
    }
    
    private static String getParameterDeclarationAsString(final ParameterDeclarationCS decl) {
    	StringBuffer result = new StringBuffer();
    	if (decl.getDirectionKind().getValue() == DirectionKindEnum.IN_VALUE) {
    		result.append("in "); //$NON-NLS-1$
    	} else if (decl.getDirectionKind().getValue() == DirectionKindEnum.OUT_VALUE) {
    		result.append("out "); //$NON-NLS-1$
    	} else if (decl.getDirectionKind().getValue() == DirectionKindEnum.INOUT_VALUE) {
    		result.append("inout "); //$NON-NLS-1$
    	}
    	
    	result.append(decl.getSimpleNameCS().getValue());
        
        String typeName = getTypeAsString(decl.getTypeSpecCS().getTypeCS());
        result.append(":").append(typeName); //$NON-NLS-1$
    	
    	return result.toString();
    }
    
    private static String getTypeAsString(TypeCS type) {
    	String typeName;
        if (type instanceof EClassifier) {
            typeName = QvtOperationalTypesUtil.getTypeFullName((EClassifier) type);
        }
        else if (type != null) {
            typeName = QvtOperationalUtil.getStringRepresentation(type);
        }
        else {
        	typeName = VoidType.SINGLETON_NAME;
        }
        
        return typeName;
    }
}
