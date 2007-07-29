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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.Node;
import org.eclipse.m2m.qvt.oml.emf.util.ui.provider.EMFLabelProvider;
import org.eclipse.m2m.qvt.oml.trace.EMappingOperation;
import org.eclipse.m2m.qvt.oml.trace.EValue;
import org.eclipse.m2m.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.trace.VarParameterValue;
import org.eclipse.swt.graphics.Image;

/**
 * @author Aleksandr Igdalov
 */
public class TraceViewLabelProvider extends EMFLabelProvider {
	private final AdapterFactoryLabelProvider myLabelProvider;

	private boolean isQualified;
	
    public TraceViewLabelProvider() {
		super();
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		myLabelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof TraceRecord) {
			TraceRecord traceRecord = (TraceRecord) element;
			StringBuffer result = new StringBuffer();
            EMappingOperation mappingOperation = traceRecord.getMappingOperation();
            if (isQualified) {
                if (mappingOperation.getPackage().length() != 0) {
                    result.append(mappingOperation.getPackage() + '.');
                }
                result.append(mappingOperation.getModule() + '.');
            }
            result.append(mappingOperation.getName());
			result.append(" ("); //$NON-NLS-1$
			if (traceRecord.getContext().getContext() != null) {
				result.append("SELF: " + getValue(traceRecord.getContext().getContext().getValue())); //$NON-NLS-1$
			}
			appendValueList(traceRecord.getParameters().getParameters(), "PARAMS", result); //$NON-NLS-1$
			appendValueList(traceRecord.getResult().getResult(), "RESULT", result); //$NON-NLS-1$
			result.append(")"); //$NON-NLS-1$
			
			return result.toString();
		} else if (element instanceof VarParameterValue) {
			VarParameterValue varParameterValue = (VarParameterValue) element;
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(varParameterValue.getKind().getLiteral().toLowerCase() + ' ');
			stringBuffer.append(varParameterValue.getName() + " : "); //$NON-NLS-1$
			stringBuffer.append(varParameterValue.getType() + " = "); //$NON-NLS-1$
			stringBuffer.append(getValue(varParameterValue.getValue()));
			return stringBuffer.toString();
		} else if (element instanceof EValue) {
			return getValue((EValue) element);
		} else if (element instanceof Node) {
            Object object = ((Node) element).getObject();
            return myLabelProvider.getText(object);
        }
        throw new RuntimeException("Unknown input:" + element.getClass()); //$NON-NLS-1$
	}
    
    @Override
	public Image getImage(Object element) {
        if (element instanceof Node) {
            Object object = ((Node) element).getObject();
            return myLabelProvider.getImage(object);
        }
		return myLabelProvider.getImage(element);
	}



	public void setShowQualifiedNames(boolean isOn) {
        isQualified = isOn;
    }
	
	private void appendValueList(EList<VarParameterValue> valueList, String prefix, StringBuffer result) {
		int size = valueList.size(); 
		if (size > 0) {
			if (result.charAt(result.length() - 1) != '(') {
				result.append(", "); //$NON-NLS-1$
			}
			result.append(prefix + ": "); //$NON-NLS-1$
			for (int i = 0, n = size - 1; i < n; i++) {
				result.append(getValue(valueList.get(i).getValue()) + ", "); //$NON-NLS-1$
			}
			result.append(getValue(valueList.get(size - 1).getValue()));
		}
	}
	
	private static String getValue(EValue eValue) {
		if (eValue.getModelElement() != null) {
			return eValue.getModelElement().eClass().getName();
        } else if (eValue.getPrimitiveValue() != null) {
            return eValue.getPrimitiveValue();
        } else if (eValue.getIntermediateElement() != null) {
            return eValue.getIntermediateElement().eClass().getName();
        } else if (!eValue.getCollection().isEmpty()) {
            return eValue.getCollectionType() + '[' + eValue.getCollection().size() + ']';
		} else {
			return "null"; //$NON-NLS-1$
		}
	}

}