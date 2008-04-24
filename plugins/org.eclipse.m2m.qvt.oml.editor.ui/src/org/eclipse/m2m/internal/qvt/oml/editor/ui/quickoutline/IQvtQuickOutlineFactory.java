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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.swt.widgets.Shell;

/**
 * @author aigdalov
 * Created on Apr 23, 2008
 */
public interface IQvtQuickOutlineFactory {
    public IInformationProvider newInformationProvider();
    public IInformationControl newInformationControl(Shell parent, int shellStyle, int treeStyle, String commandId,
            QvtEditor editor, ISourceViewer sourceViewer);
}