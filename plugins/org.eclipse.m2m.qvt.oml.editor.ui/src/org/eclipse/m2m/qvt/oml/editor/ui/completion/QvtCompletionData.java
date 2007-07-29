package org.eclipse.m2m.qvt.oml.editor.ui.completion;

import java.util.HashMap;
import java.util.Map;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.internal.cst.CSTNode;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 5, 2007
 */

public class QvtCompletionData {
	private final QvtEditor myEditor;
	private final ITextViewer myViewer;
	private final int myOffset;
	private final IToken myLeftToken;
	private final IToken myCurrentToken;
	private final CSTNode myCstNode;
	private final QvtOperationalEnv myEnvironment;
	private final MappingModuleCS myModuleCS;
	private final QvtOpLexer myLexer;
	private final PrsStream myPrsStream;
	private final CompiledModule myCompiledModule;
	private final Map<String, Object> myUserData = new HashMap<String, Object>();
	
	public QvtCompletionData(QvtEditor editor, ITextViewer viewer, int offset,
			IToken leftToken, IToken currentToken, CSTNode cstNode,
			QvtOperationalEnv environment, MappingModuleCS moduleCS,
			QvtOpLexer lexer, PrsStream prsStream, CompiledModule compiledModule) {
		myEditor = editor;
		myViewer = viewer;
		myOffset = offset;
		myLeftToken = leftToken;
		myCurrentToken = currentToken;
		myCstNode = cstNode;
		myEnvironment = environment;
		myModuleCS = moduleCS;
		myLexer = lexer;
		myPrsStream = prsStream;
		myCompiledModule = compiledModule;
	}

	public QvtEditor getEditor() {
		return myEditor;
	}

	public ITextViewer getViewer() {
		return myViewer;
	}

	public int getOffset() {
		return myOffset;
	}

	public IToken getLeftToken() {
		return myLeftToken;
	}

	public IToken getCurrentToken() {
		return myCurrentToken;
	}

	public CSTNode getCstNode() {
		return myCstNode;
	}

	public QvtOperationalEnv getEnvironment() {
		return myEnvironment;
	}
	
	public MappingModuleCS getModuleCS() {
		return myModuleCS;
	}

	public QvtOpLexer getLexer() {
		return myLexer;
	}

	public PrsStream getPrsStream() {
		return myPrsStream;
	}

	public CompiledModule getCompiledModule() {
		return myCompiledModule;
	}
	
	public Map<String, Object> getUserData() {
		return myUserData;
	}

	public boolean isValid() {
		return (myEditor != null) && (myViewer != null) 
				&& (myOffset >= 0)&& (myLeftToken != null) && (myCstNode != null)
				&& (myEnvironment != null) && (myModuleCS != null) && (myLexer != null)
				&& (myPrsStream != null) && (myCompiledModule != null);
	}
	
	public void showError(String message) {
		ErrorDialog.openError(myViewer.getTextWidget().getShell(),
				Messages.QvtCompletionData_ErrorPerformingCodeCompletion, null,
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, message)); 
	}
}