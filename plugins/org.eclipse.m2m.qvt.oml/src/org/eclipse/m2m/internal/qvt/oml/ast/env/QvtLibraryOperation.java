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

package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ValidationMessages;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.LibraryCreationException;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.LibraryOperation;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.ExpressionInOCL;

/**
 * @author sboyko
 *
 */
public class QvtLibraryOperation {
	
	public QvtLibraryOperation(QvtOperationalEnv env, LibraryOperation libOp) throws LibraryCreationException {
		QvtOperationalEnv parseEnv = new QvtOperationalEnvFactory().createEnvironment(null);
		EPackage oclStdlibPackage = env.getOCLStandardLibrary().getOclAny().getEPackage();
		parseEnv.getEPackageRegistry().put(oclStdlibPackage.getNsURI(), oclStdlibPackage);
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
        ExpressionInOCL<EClassifier, EParameter> exprInOcl = parseConstraintUnvalidated(fakeOperation, parseEnv, libOp);
        
        myParamTypes = new ArrayList<EClassifier>(exprInOcl.getParameterVariable().size());
        for (Variable<EClassifier, EParameter> param : exprInOcl.getParameterVariable()) {
        	if(param.getType() == null) {
        		throw new LibraryCreationException(MessageFormat.format(
        				ValidationMessages.LibOperationAnalyser_OperationParsingError,
        				fakeOperation));
        	}
        	
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
			QvtOperationalEnv env, LibraryOperation libOp) throws LibraryCreationException {
		OCL ocl = OCL.newInstance(env);
		Constraint constraint = null;
		
		try {	 
			OCLStandardLibrary<EClassifier> oclStdlib = env.getOCLStandardLibrary();
			EClassifier oclAny = oclStdlib.getOclAny();
			if(oclAny.getName().equals(libOp.getContext())) {
				// Note: a workaround for OclAny context which is not 
				// supported by the constraint parser, so OclAny instance is passed 
				// and trimmed from the def: constraint specification
				int startPos = text.indexOf(" " + OCL_DEF) + OCL_DEF.length() + 1; //$NON-NLS-1$
				String trimmedText = startPos < text.length() ? text.substring(startPos) : text;
				
				OCL.Helper helper = ocl.createOCLHelper();
				helper.setContext(oclStdlib.getOclAny());
				constraint = helper.createConstraint(ConstraintKind.DEFINITION, trimmedText);				
			} else {
				List<Constraint> constraints = ocl.parse(new OCLInput(text));
				constraint = constraints.get(0);
			}
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
            String nextParameterType = getFakeTypeText(nextType);
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
        result.append(getFakeTypeText(libOp.getReturnType()));

        result.append(Common_EQ).append("let r:"); //$NON-NLS-1$
        result.append(getFakeTypeText(libOp.getReturnType()));
        result.append(Common_EQ);
        result.append("null in r"); //$NON-NLS-1$

        return result.toString();
	}

	private String getFakeTypeText(String type) {
        return type != null ? type : AnyType.SINGLETON_NAME;
	}

    private static final String OCL_CONTEXT = "context"; //$NON-NLS-1$
    private static final String OCL_DEF = "def:"; //$NON-NLS-1$
    private static final String Common_SPACE = " "; //$NON-NLS-1$
    private static final String Common_BRACKET_OPEN = "("; //$NON-NLS-1$
    private static final String Common_BRACKET_CLOSE = ")"; //$NON-NLS-1$
    private static final String Common_COMMA = ","; //$NON-NLS-1$
    private static final String Common_COLON = ":"; //$NON-NLS-1$
    private static final String Common_EQ = "="; //$NON-NLS-1$
    private static final String PARAMETER_PREFIX = "param_"; //$NON-NLS-1$
	
	private final EClassifier myContextType;
	private final EClassifier myReturnType;
	private final List<EClassifier> myParamTypes;
	
}
