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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;
import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContextImpl;

/**
 * @author aigdalov
 * Created on Oct 1, 2007
 */

public class ImportModuleCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        return leftToken.getKind() == QvtOpLPGParsersym.TK_import;
    }


    public void addPropoposals(Collection<ICompletionProposal> proposals,
            QvtCompletionData data) {
        addLocalModulesProposals(proposals, data);
        addDeployedModulesProposals(proposals, data);
        final ResolutionContextImpl loadContext = new ResolutionContextImpl(data.getCFile());
        for (AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor : BlackboxRegistry.INSTANCE.getCompilationUnitDescriptors(loadContext)) {
            String proposalString = abstractCompilationUnitDescriptor.getQualifiedName();
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.MAPPING, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);        	
		}        
        
    }

    private void addLocalModulesProposals(
            Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        CFile compiledFile = data.getCFile();
        CFolder rootFolder = compiledFile.getParent();
        addFolderProposals(rootFolder, compiledFile, proposals, data, new String[] {});
    }

    private void addFolderProposals(CFolder folder, CFile excludedFile,
            Collection<ICompletionProposal> proposals, QvtCompletionData data, String[] path) {
        try {
            CResource[] members = folder.members();
            for (CResource member : members) {
                if (member instanceof CFile) {
                    CFile file = (CFile) member;
                    if ((path.length == 0) && file.getName().equals(excludedFile.getName())) {
                        continue;
                    }
                    if (!MDAConstants.QVTO_FILE_EXTENSION.equals(file.getExtension())) {
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String pathElement : path) {
                        stringBuilder.append(pathElement).append('.');
                    }
                    stringBuilder.append(file.getUnitName());
                    QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(stringBuilder.toString(), CategoryImageConstants.CLASS, data);
                    CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
                }
            }
            for (CResource member : members) {
                if (member instanceof CFolder) {
                    CFolder subfolder = (CFolder) member;
                    String[] newPath = new String[path.length + 1];
                    System.arraycopy(path, 0, newPath, 0, path.length);
                    newPath[newPath.length - 1] = subfolder.getName();
                    addFolderProposals(subfolder, excludedFile, proposals, data, newPath);
                }
            }
        } catch (IOException e) {
            Activator.log(e);
        }
    }


    private void addDeployedModulesProposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        List<CompiledTransformation> transformations = QvtTransformationRegistry.getInstance().getTransformations(TransformationRegistry.EMPTY_FILTER);
        for (CompiledTransformation transformation : transformations) {
            String proposalString = transformation.getId();
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.CLASS, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }
}