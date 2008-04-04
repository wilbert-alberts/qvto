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
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import java.io.Reader;

import lpg.lpgjavaruntime.BadParseException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerMessages;
import org.eclipse.m2m.internal.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTFactory;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParser;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.osgi.util.NLS;


public class QvtOperationalParser {
	
	public QvtOperationalParser() {
	}
	
	public MappingModuleCS parse(final Reader is, final String name, QvtOperationalEnv env) {
		MappingModuleCS result = null;

		QvtOpLexer lexer = new QvtOpLexer(env);
		myParser = new RunnableQVTParser(lexer);		
		try {			
		    lexer.initialize(new OCLInput(is).getContent(), name);
			lexer.lexToTokens(myParser);
	
			result = (MappingModuleCS) myParser.runParser(100);	
		}
		catch (ParserException ex) {
			env.reportError(ex.getLocalizedMessage(), 0, 0);
		}

		if (result == null) {
			result = CSTFactory.eINSTANCE.createMappingModuleCS();
			
			if (!env.hasErrors()) {
				env.reportError(NLS.bind(
						CompilerMessages.moduleTransformationExpected, new Object[] { name }),0, 0);
			}
		}
		
		return result;
	}

	public Module analyze(final ParsedModuleCS moduleCS, final QvtCompiler compiler, QvtOperationalFileEnv env, QvtCompilerOptions options) {
		Module module = null;
	
		env.setQvtCompilerOptions(options);
		try {
			QvtOperationalVisitorCS visitor = options.getQvtOperationalVisitorCS();
			if (visitor == null) {
	            visitor = new QvtOperationalVisitorCS(moduleCS.getParser(), options);
			}
			module = visitor.visitMappingModule(moduleCS, env, compiler);
		} catch (SemanticException e) {
			env.reportError(e.getLocalizedMessage(), 0, 0);
		}
		
		if (module != null && options.isReportErrors()) {
			env.setCheckForDuplicateErrors(true);
			QvtOperationalValidationVisitor validation = new QvtOperationalValidationVisitor(env);
			validation.visitModule(module);
			env.setCheckForDuplicateErrors(false);
		}
		
		return module;
	}
		
	
	private class RunnableQVTParser extends QvtOpLPGParser {
		public RunnableQVTParser(QvtOpLexer lexStream) {
			super(lexStream);
		}
		
		public EObject runParser(int max_error_count) throws ParserException {
			return parseTokensToCST(null, max_error_count);
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
			// FIXME - review the strange block below
			if (tokenText.contains(getTokenKindName(QvtOpLPGParsersym.TK_ERROR_TOKEN))) {
				return;
			} 
			super.reportError(errorCode, locationInfo, leftToken, rightToken, tokenText);
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
		
		// FIXME - OCL 1.2 migration, workaround for ArrayIndexOutBounds
		@Override
		public String computeInputString(int left, int right) {
			char[] chars = getInputChars();
			
			if(right < left) {
				right = left;
			}
			
			if(right >= chars.length) {
				right = chars.length - 1;
			}

			StringBuffer result = new StringBuffer(right - left + 1);
			
			if (chars.length > 0) {
				for (int i = left; i <= right; i++) {
					if (chars[i] == '\t') {
						result.append(' ');
					} else if (chars[i] == '\n' || chars[i] == '\r' || chars[i] == '\f') {
						if (i > 0) {
							if (!Character.isWhitespace(chars[i-1])) {
								result.append(' ');
							}
						}
					} else {
						result.append(chars[i]);
					}

				}
			}
			return result.toString();
		}		
	}
	    
    public AbstractQVTParser getParser() {
		return myParser;
	}
	
    private RunnableQVTParser myParser;
}