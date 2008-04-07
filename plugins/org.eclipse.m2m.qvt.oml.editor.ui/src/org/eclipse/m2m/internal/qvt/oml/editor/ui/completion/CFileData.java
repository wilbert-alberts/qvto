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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class CFileData {
    private final CFile myCFile;
    private final QvtCompletionData myData;
    private final List<CFile> myImportedFiles = new ArrayList<CFile>();
    private QvtOpLexer myLexer;
    private MappingModuleCS myMappingModuleCS;
    private String myLightweightScript;
 
    public CFileData(CFile cFile, QvtCompletionData data) {
        myCFile = cFile;
        myData = data;
    }
    
    public CFile getCFile() {
        return myCFile;
    }

    public CFile[] getImportedFiles() {
        return myImportedFiles.toArray(new CFile[myImportedFiles.size()]);
    }
    
    public void addImportedFile(CFile cFile) {
        myImportedFiles.add(cFile);
    }
    
    public QvtOpLexer getLexer() {
        return myLexer;
    }

    public void setLexer(QvtOpLexer lexer) {
        myLexer = lexer;
    }
    
    public MappingModuleCS getMappingModuleCS() {
        return myMappingModuleCS;
    }

    public void setMappingModuleCS(MappingModuleCS mappingModuleCS) {
        myMappingModuleCS = mappingModuleCS;
        addImportedModules();
    }

    private void addImportedModules() {
        for (ImportCS importCS : myMappingModuleCS.getImports()) {
            String id = QvtOperationalParserUtil.getStringRepresentation(importCS.getPathNameCS(), "."); //$NON-NLS-1$
            if (importCS instanceof ModuleImportCS) {
                IImportResolver importResolver = myData.getQvtCompiler().getKernel().getImportResolver();
                CFile importedFile = importResolver.resolveImport(id);
                if (importedFile != null) {
                    addImportedFile(importedFile);
                }
            } else if (importCS instanceof LibraryImportCS) {
//                Library library = OclEmfPlugin.getDefault().getLibrariesRegistry().getLibrary(id);
//                if (library == null) {
//                    library = QvtLibraryRegistry.getInstance().getQvtLibrary(id);
//                }
//                if (library != null) {
//                    addImportedLibrary(library);
//                }
            }
        }
    }

    public String getLightweightScript() {
        return myLightweightScript;
    }

    public void setLightweightScript(String lightweightScript) {
        myLightweightScript = lightweightScript;
    }
}