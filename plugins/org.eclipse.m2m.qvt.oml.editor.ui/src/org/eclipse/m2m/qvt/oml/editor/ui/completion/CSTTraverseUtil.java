package org.eclipse.m2m.qvt.oml.editor.ui.completion;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.CSTBindingUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.IsMarkedPreCS;

/**
 * @author aigdalov
 */

public class CSTTraverseUtil {
    public static final<T> T getParent(CSTNode cstNode, Class<T> clazz) {
        return getParent(cstNode, clazz, null);
    }
    
    public static final<T> boolean isWithin(CSTNode cstNode, Class<T> clazz) {
        return isWithin(cstNode, clazz, null);
    }

    public static final<T> T getParent(CSTNode cstNode, Class<T> clazz, Class<?>[] excludeClasses) {
        EObject tempEObject = cstNode;
        while ((tempEObject != null) && !(clazz.isInstance(tempEObject))) {
            if (excludeClasses != null) {
                for (Class<?> excludedClass : excludeClasses) {
                    if (excludedClass.isInstance(tempEObject)) {
                        return null;
                    }
                }
            }
            tempEObject = tempEObject.eContainer();
        }
        return (T) tempEObject;
    }
    
    public static final<T> boolean isWithin(CSTNode cstNode, Class<T> clazz, Class<?>[] excludeClasses) {
        return getParent(cstNode, clazz, excludeClasses) != null;
    }
    
    public static final QvtOpLexer getQvtOpLexer(CSTNode cstNode) {
        MappingModuleCS module = getParent(cstNode, MappingModuleCS.class);
        return CSTBindingUtil.getQvtOpLexer(module);
    }
    
    public static final CSTNode findCSTNodeForToken(CSTNode root, IToken token) {
        CSTNode result = root;
        for (TreeIterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
            EObject next = iterator.next();
            if (next instanceof CSTNode) {
                CSTNode child = (CSTNode) next;
                if ((child.getStartOffset() >= result.getStartOffset()) && (child.getEndOffset() <= result.getEndOffset())
                        && (token.getStartOffset() >= child.getStartOffset()) && (token.getEndOffset() <= child.getEndOffset())) {
                    result = child;
                }
            }
        }
        return result;
    }

    public static final CSTNode findCSTNode(CSTNode root, int offset) {
        CSTNode result = root;
        for (TreeIterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
            EObject next = iterator.next();
            if (next instanceof CSTNode) {
                CSTNode child = (CSTNode) next;
                if ((child.getStartOffset() >= result.getStartOffset()) && (child.getEndOffset() <= result.getEndOffset())
                        && (offset >= child.getStartOffset()) && (offset <= child.getEndOffset())) {
                    if (!(child instanceof IsMarkedPreCS)) {
                        result = child;
                    }
                }
            }
        }
        return result;
    }
}