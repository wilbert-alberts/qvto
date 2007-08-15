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
package org.eclipse.m2m.qvt.oml.ast.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.ParseErrorCodes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnvFactory;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.CompilerMessages;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.adapters.CSTBindingUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParser;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.internal.parser.OCLLexer;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalParser {
	
	public QvtOperationalParser() {
	}

	public MappingModuleCS parse(final Reader is, final String name) {
		MappingModuleCS result = null;
		QvtOpLexer lexer = new QvtOpLexer();
		myEnv = new QvtOperationalEnvFactory().createEnvironment(null, null, null);
		try {
			lexer.initialize(new OCLInput(is).getContent(), name);
			RunnableQVTParser parser = new RunnableQVTParser(lexer);
			lexer.lexer(parser);
	
			result = (MappingModuleCS) parser.runParser(100);	
		}
		catch (ParserException ex) {
			getErrorsList().add(new QvtMessage(ex.getLocalizedMessage(), 0, 0));
		}

		if (result == null) {
			result = CSTFactory.eINSTANCE.createMappingModuleCS();
			
			if (getErrorsList().isEmpty()) {
				getErrorsList().add(new QvtMessage(
						NLS.bind(CompilerMessages.moduleTransformationExpected, new Object[] { name }), 0, 0));
			}
		}
		
		CSTBindingUtil.bindQvtOpLexer(result, lexer);
		
		return result;
	}

	public Module analyze(final ParsedModuleCS moduleCS, final QvtCompiler compiler, QvtOperationalEnv env, QvtCompilerOptions options) {
		Module module = null;
		List<QvtMessage> parentWarnings = new ArrayList<QvtMessage>(env != null ? env.getWarningsList() : Collections.<QvtMessage>emptyList());
		List<QvtMessage> parentErrors = new ArrayList<QvtMessage>(env != null ? env.getErrorsList() : Collections.<QvtMessage>emptyList());
		myEnv = new QvtOperationalEnvFactory().createEnvironment(env, moduleCS.getSource(), compiler);
		myEnv.setErrorRecordFlag(options.isReportErrors());
		try {
			OCLLexer oclLexer = new OCLLexer();
			oclLexer.initialize(new OCLInput(moduleCS.getSource().getContents()).getContent(), moduleCS.getSource().getName());
			QvtOperationalVisitorCS visitor = new QvtOperationalVisitorCS(oclLexer, myEnv, options);
			module = visitor.visitMappingModule(moduleCS, myEnv);
		} catch (SemanticException e) {
			getErrorsList().add(new QvtMessage(e.getLocalizedMessage(), 0, 0));
		} catch (ParserException e) {
			getErrorsList().add(new QvtMessage(e.getLocalizedMessage(), 0, 0));
		} catch (IOException e) {
			getErrorsList().add(new QvtMessage(e.getLocalizedMessage(), 0, 0));
		}
		
		if (env != null) {
			List<QvtMessage> newWarnings = new ArrayList<QvtMessage>(env.getWarningsList());
			newWarnings.removeAll(parentWarnings);
			List<QvtMessage> newErrors = new ArrayList<QvtMessage>(env.getErrorsList());
			newErrors.removeAll(parentErrors);
			
			myEnv.getWarningsList().addAll(newWarnings);
			myEnv.getErrorsList().addAll(newErrors);
			env.getWarningsList().removeAll(newWarnings);
			env.getErrorsList().removeAll(newErrors);
		}
		
		return module;
	}
		
	public List<QvtMessage> getErrorsList() {
		if (myEnv != null) {
			return myEnv.getErrorsList();
		}
		return Collections.emptyList();
	}

	public List<QvtMessage> getWarningsList() {
		if (myEnv != null) {
			return myEnv.getWarningsList();
		}
		return Collections.emptyList();
	}


	private class RunnableQVTParser extends QvtOpLPGParser {
		public RunnableQVTParser(LexStream lexStream) {
			super(lexStream);
		}
		
		public EObject runParser(int max_error_count) throws ParserException {
			return parser(null, max_error_count);
		}
		
		@Override
		protected void OnParseError(BadParseException e) {
			super.OnParseError(e);
//			IToken token = (IToken) getTokens().get(e.error_token);
//			getErrorsList().add(new QvtMessage(e.getLocalizedMessage(), token.getStartOffset(),
//					token.getEndOffset()-token.getStartOffset()));
		}
		
		@Override
		public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
			if (tokenText.contains(getTokenKindName(QvtOpLPGParsersym.TK_ERROR_TOKEN))) {
				return;
			}
			super.reportError(errorCode, locationInfo, leftToken, rightToken, tokenText);

			IToken leftTok = (IToken) getTokens().get(leftToken);
			IToken rightTok = (IToken) getTokens().get(rightToken);
			if (tokenText.toLowerCase().contains("error")) { //$NON-NLS-1$
				tokenText = "'" + leftTok.toString() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			String msg = tokenText + " " + ParseErrorCodes.errorMsgText[errorCode]; //$NON-NLS-1$
			if (errorCode == 11) {
				msg = "Syntax error"; //$NON-NLS-1$
			}
			getErrorsList().add(new QvtMessage(msg, leftTok.getStartOffset(),
					rightTok.getEndOffset()-leftTok.getStartOffset()+1));
		}
		
		@Override
		public void reportError(int errorCode, String locationInfo, String tokenText) {
			super.reportError(errorCode, locationInfo, tokenText);
		}
		
		@Override
		public void reportError(int i, int j) {
			super.reportError(i, j);
		}
		
		@Override
		public void reportError(int i, String code) {
			super.reportError(i, code);
		}
	}

	/**
	* TODO - Exposed temporarily, may be removed as soon as data completion gets supported
	*/
	public QvtOperationalEnv getEnvironment() {
		return myEnv;
	}
	
	private QvtOperationalFileEnv myEnv;

}
