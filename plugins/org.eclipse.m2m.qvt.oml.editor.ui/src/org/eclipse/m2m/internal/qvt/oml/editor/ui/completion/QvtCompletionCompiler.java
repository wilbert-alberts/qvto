/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.IKeywordHandler;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.KeywordHandlerRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.cst.CSTNode;

/**
 * @author aigdalov
 * Created on Oct 30, 2007
 */
public class QvtCompletionCompiler extends QVTOCompiler {
    private final QvtCompletionData myData;
    private final Map<URI, CFileData> myCFileDataMap = new LinkedHashMap<URI, CFileData>();
    private QvtOperationalEnv myEnvironment;

    public QvtCompletionCompiler(UnitResolver importResolver, IMetamodelRegistryProvider metamodelProvider, QvtCompletionData data) {
        super(importResolver, metamodelProvider);
        myData = data;
    }
    
    public Map<URI, CFileData> getCFileDataMap() {
        return myCFileDataMap;
    }

    public QvtOpLexer createLexer(UnitProxy unit) throws IOException, ParserException, BadLocationException {
        CFileData cFileData = getCFileData(unit.getURI());
        if (cFileData.getLexer() != null) {
            return cFileData.getLexer();
        }
        Reader reader = createReader(unit);
        
		QvtOpLexer lexer = new QvtOpLexer(new QvtOperationalEnvFactory(
				getEPackageRegistry(unit.getURI())).createEnvironment(unit.getURI()));
        
        cFileData.setLexer(lexer);
        try {
            lexer.initialize(new OCLInput(reader).getContent(), unit.getURI().lastSegment());
            lexer.lexToTokens(new QvtOpLPGParser(lexer));
        } finally {
            reader.close();
        }
        return lexer;    
    }

    @Override
    protected Reader createReader(UnitProxy source) throws IOException {
      if (source.getURI().equals(myData.getCFile().getURI())) {
    	  String documentText = myData.getDocument().get();
    	  return new StringReader(documentText);
      }
    	
      return super.createReader(source);
    }
    
    public QvtOperationalEnv compileAll() {
        if (myEnvironment == null) {
            URI uri = this.myData.getCFile().getURI();
			myEnvironment = new QvtOperationalEnvFactory(getEPackageRegistry(uri)).createEnvironment(uri);

            QvtCompilerOptions options = new QvtCompilerOptions();
            options.setReportErrors(false);
            options.setShowAnnotations(false);
            options.setSourceLineNumbersEnabled(false);

            try {
                compile(myData.getCFile(), options, null);
            } catch (MdaException ex) {
              Activator.log(ex);
            }
        }
        return myEnvironment;
    }
    
    @Override
    protected void onCompilationUnitFinished(CompiledUnit unit) {    	
    	CFileData cFileData = getCFileData(unit.getURI());
    	cFileData.setCompiledUnit(unit);
    }
    
    @Override
    protected QvtOperationalVisitorCS createAnalyzer(AbstractQVTParser parser, QvtCompilerOptions options) {
		return new QvtCompletionVisitorCS(parser, options, null) {
			@Override
			protected void setEnv(QvtOperationalEnv env) {			
				super.setEnv(env);
				myEnvironment = env;
			}
		};
    }

    @Override
    protected CSTParseResult parse(UnitProxy source, QvtCompilerOptions options) throws ParserException {
     	CFileData cFileData = compile(source);
		AbstractQVTParser qvtParser = (AbstractQVTParser) cFileData.getLexer().getParser();

    	UnitCS unitCS = cFileData.getUnitCS();
    	
    	QvtOperationalFileEnv env = (QvtOperationalFileEnv)cFileData.getLexer().getEnvironment();
    	CSTParseResult result = new CSTParseResult();
    	result.unitCS = unitCS;
    	result.env = env;
    	result.parser = qvtParser;
    	return result;
    }
    
    
    private CFileData compile(UnitProxy cFile) {
        CFileData cFileData = getCFileData(cFile.getURI());
        try {
            QvtOpLexer lexer = createLexer(cFile);
            PrsStream prsStream = lexer.getPrsStream();
            IKeywordHandler[] keywordHandlers = KeywordHandlerRegistry.getInstance().getKeywordHandlers();
            StringBuilder lightweightScriptBuilder = new StringBuilder(lexer.getStreamLength());
            for (int i = 0, n = prsStream.getSize(); i < n; i++) {
                IToken token = prsStream.getTokenAt(i);
                for (IKeywordHandler keywordHandler : keywordHandlers) {
                    String contribution = keywordHandler.handle(token, prsStream, myData, cFileData);
                    if (contribution != null) {
                        int offsetDelta = token.getStartOffset() - lightweightScriptBuilder.length();
                        for (int j = 0; j < offsetDelta - 1; j++) {
                            lightweightScriptBuilder.append(' ');
                        }
                        lightweightScriptBuilder.append(contribution);
                        break;
                    }
                }
            }
            String lightweightScript = lightweightScriptBuilder.toString();
            cFileData.setLightweightScript(lightweightScript);
            CSTNode cstNode = LightweightParserUtil.parse(lightweightScript, cFile, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_PARSER);

            UnitCS unitCS = CSTFactory.eINSTANCE.createUnitCS();
        	unitCS.setStartOffset(0);
        	unitCS.setStartOffset(lexer.getStreamLength());
            
            if (cstNode instanceof MappingModuleCS) {  	
            	unitCS.getTopLevelElements().add((MappingModuleCS) cstNode);
            }
            
            cFileData.setUnitCS(unitCS);            
        } catch (Exception ex) {
            Activator.log(ex);
        }
        return cFileData;
    }
    
    public CFileData getCFileData(URI unitURI) {
        CFileData cFileData = myCFileDataMap.get(unitURI);
        if (cFileData == null) {
            cFileData = new CFileData(unitURI, myData);
            myCFileDataMap.put(unitURI, cFileData);        
        }
        return cFileData;
    }
    
    public CFileData getCFileData(MappingModuleCS mappingModuleCS) {
        for (CFileData cFileData : myCFileDataMap.values()) {
        	UnitCS unitCS = cFileData.getUnitCS();
        	if(unitCS != null && unitCS.getModules().contains(mappingModuleCS)) {
                return cFileData;
            }
        }
        return null;
    }
}