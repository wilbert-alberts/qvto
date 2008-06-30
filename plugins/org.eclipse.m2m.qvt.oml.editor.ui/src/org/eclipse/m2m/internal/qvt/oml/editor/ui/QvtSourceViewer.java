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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.QvtQuickOutlineFactoryRegistry;
import org.eclipse.swt.widgets.Composite;

/**
 * @author aigdalov
 * Created on Apr 10, 2008
 */
public class QvtSourceViewer extends ProjectionViewer {
    public static final int SHOW_OUTLINE = 100;
    private IInformationPresenter myOutlinePresenter;

    public QvtSourceViewer(Composite parent, IVerticalRuler ruler,
            IOverviewRuler overviewRuler, boolean showsAnnotationOverview,
            int styles) {
        super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
    }

    @Override
    public boolean canDoOperation(int operation) {
        if (operation == SHOW_OUTLINE) {
            return myOutlinePresenter != null;
        }

        return super.canDoOperation(operation);
    }

    @Override
    public void doOperation(int operation) {
        if (getTextWidget() == null) {
            return;
        }

        switch (operation) {
            case SHOW_OUTLINE:
                if ((myOutlinePresenter != null) && (QvtQuickOutlineFactoryRegistry.getQvtQuickOutlineFactory() != null)) {
                    myOutlinePresenter.showInformation();
                }
                return;
        }

        super.doOperation(operation);
    }

    @Override
    public void configure(SourceViewerConfiguration configuration) {
        super.configure(configuration);
        if (configuration instanceof QvtConfiguration) {
            QvtConfiguration qvtConfiguration = (QvtConfiguration) configuration;
            if (QvtQuickOutlineFactoryRegistry.getQvtQuickOutlineFactory() != null) {
                myOutlinePresenter = qvtConfiguration.getOutlinePresenter(this);
                if (myOutlinePresenter != null) {
                    myOutlinePresenter.install(this);
                }
            }
        }
    }

    @Override
    public void unconfigure() {
        if (myOutlinePresenter != null) {
            myOutlinePresenter.uninstall();
            myOutlinePresenter = null;
        }
        super.unconfigure();
    }
}