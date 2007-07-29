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

package org.eclipse.m2m.qvt.oml.ast.environment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.LibraryCreationException;
import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.LibraryOperation;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * @author sboyko
 *
 */
public class QvtLibraryOperation {
	
	public QvtLibraryOperation(QvtOperationalEnv env, LibraryOperation libOp) throws LibraryCreationException {
		QvtOperationalEnv parseEnv = new QvtOperationalEnvFactory().createEnvironment(null, null);
		parseEnv.getEPackageRegistry().put(OCLStandardLibraryImpl.stdlibPackage.getNsURI(), OCLStandardLibraryImpl.stdlibPackage);
		if (libOp.getLibrary().getInMetamodels() != null) {
			for (String mm : libOp.getLibrary().getInMetamodels()) {
				parseEnv.registerMetamodel(mm, Collections.<String>emptyList());
			}
		}
		if (libOp.getLibrary().getOutMetamodels() != null) {
			for (String mm : libOp.getLibrary().getOutMetamodels()) {
				parseEnv.registerMetamodel(mm, Collections.<String>emptyList());
			}
		}
		
        String fakeOperation = getFakeOperation(libOp);
        ExpressionInOCL<EClassifier, EParameter> exprInOcl = parseConstraintUnvalidated(fakeOperation, parseEnv);
        
        if (exprInOcl.getParameterVariable() == null) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
                    fakeOperation));
        }
        myParamTypes = new ArrayList<EClassifier>(exprInOcl.getParameterVariable().size());
        for (Variable<EClassifier, EParameter> param : exprInOcl.getParameterVariable()) {
        	myParamTypes.add(param.getType());
        }
        
        if (exprInOcl.getContextVariable() == null) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
                    fakeOperation));
        }
        myContextType = exprInOcl.getContextVariable().getType();
        
        if (exprInOcl.getBodyExpression() == null) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
                    fakeOperation));
        }
        myReturnType = exprInOcl.getBodyExpression().getType();
	}

	public EClassifier getContextType() {
		return myContextType;
	}

	public EClassifier getReturnType() {
		return myReturnType;
	}

	public EClassifier[] getParamTypes() {
		return (EClassifier[]) myParamTypes.toArray(new EClassifier[myParamTypes.size()]);
	}
	
	/**
	 * Parses the specified <code>text</code> as an OCL constraint, without
	 * validating it.
	 * 
	 * @param text the OCL text
	 * @return the OCL constraint expression, unvalidated
	 */
	protected ExpressionInOCL<EClassifier, EParameter> parseConstraintUnvalidated(String text,
			QvtOperationalEnv env) throws LibraryCreationException {
		OCL ocl = OCL.newInstance(env);
		Constraint constraint = null;
		
		try {
			List<Constraint> constraints = ocl.parse(new OCLInput(text));
			constraint = constraints.get(0);
		} catch (ParserException e) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_ParametersOsReturnTypeNotFound,
                    text, e.getLocalizedMessage()));
		} catch (IllegalArgumentException e) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_ParametersOsReturnTypeNotFound,
                    text, e.getLocalizedMessage()));
		}
		
		ExpressionInOCL<EClassifier, EParameter> result = constraint.getSpecification();
		if (result == null) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
                    text));
		}
		
		try {
			if (result.toString() == null) {
	            throw new LibraryCreationException(MessageFormat.format(
	                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
	                    text));
			}
		} catch (RuntimeException e) {
            throw new LibraryCreationException(MessageFormat.format(
                    ValidationMessages.LibOperationAnalyser_OperationParsingError,
                    text));
		}
		
		return result;
	}
	
	private String getFakeOperation(LibraryOperation libOp) {
        StringBuffer result = new StringBuffer();

        result.append(OCL_CONTEXT);
        result.append(Common_SPACE);

        result.append(libOp.getContext());
        result.append(Common_SPACE);

        result.append(OCL_DEF);
        result.append(Common_SPACE);

        result.append(libOp.getName());
        result.append(Common_BRACKET_OPEN);
        int counter = 0;
        for (String nextType : libOp.getParameterTypes()) {
            String nextParameterType = getType(nextType);
            if (counter > 0) {
                result.append(Common_COMMA);
            }
            result.append(PARAMETER_PREFIX);
            result.append(counter);
            result.append(Common_COLON);
            result.append(nextParameterType);
            counter++;
        }
        result.append(Common_BRACKET_CLOSE);
        result.append(Common_COLON);
        result.append(getType(libOp.getReturnType()));

        result.append(Common_EQ);
        result.append(Common_QUOTATION_MARK);
        result.append(Common_QUOTATION_MARK);
        result.append(Common_DOT);
        result.append(PredefinedType.OCL_AS_TYPE_NAME);
        result.append(Common_BRACKET_OPEN);
        result.append(getType(libOp.getReturnType()));
        result.append(Common_BRACKET_CLOSE);

        return result.toString();
	}

	private String getType(String type) {
        return type != null ? type : AnyType.SINGLETON_NAME;
	}

    private static final String OCL_CONTEXT = "context"; //$NON-NLS-1$
    private static final String OCL_DEF = "def:"; //$NON-NLS-1$
    private static final String Common_SPACE = " "; //$NON-NLS-1$
    private static final String Common_BRACKET_OPEN = "("; //$NON-NLS-1$
    private static final String Common_BRACKET_CLOSE = ")"; //$NON-NLS-1$
    private static final String Common_COMMA = ","; //$NON-NLS-1$
    private static final String Common_DOT = "."; //$NON-NLS-1$
    private static final String Common_COLON = ":"; //$NON-NLS-1$
    private static final String Common_EQ = "="; //$NON-NLS-1$
    private static final String Common_QUOTATION_MARK = "'"; //$NON-NLS-1$
    private static final String PARAMETER_PREFIX = "param_"; //$NON-NLS-1$
	
	private final EClassifier myContextType;
	private final EClassifier myReturnType;
	private final List<EClassifier> myParamTypes;
	
}
