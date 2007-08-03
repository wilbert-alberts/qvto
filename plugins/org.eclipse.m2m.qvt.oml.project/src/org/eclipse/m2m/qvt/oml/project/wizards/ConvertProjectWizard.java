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
package org.eclipse.m2m.qvt.oml.project.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.qvt.oml.project.QVTProjectPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;


public class ConvertProjectWizard extends Wizard implements INewWizard {
    protected IWorkbench workbench;

    protected List<IProject> projectsToConvert = new ArrayList<IProject>();

    protected ConvertionPage conversionPage;

    public static interface Converter {
        void addNature(IProject project) throws CoreException;
        boolean hasNature(IProject project) throws CoreException;
    };
    
    public ConvertProjectWizard(Converter converter) {
        myConverter = converter;
        setWindowTitle(QVTProjectPlugin.getResourceString("ConvertToMDAProjectWizard.Title"));//$NON-NLS-1$
        setNeedsProgressMonitor(true);
    }

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        for (Iterator i = selection.iterator(); i.hasNext();) {
            Object object = i.next();
            if (object instanceof IProject) {
                IProject project = (IProject) object;
                if (project.isOpen() && !hasNature(project)) {
                    projectsToConvert.add(project);
                }
            }
        }
    }

    @Override
	public void addPages() {
        super.addPages();
        conversionPage = new ConvertionPage();
        addPage(conversionPage);
    }

    @Override
	public boolean performFinish() {
        IRunnableWithProgress operation = new WorkspaceModifyOperation() {
            @Override
			public void execute(IProgressMonitor monitor) {
                try {
                    for(int i=0;i<projectsToConvert.size();i++){
                        IProject project = (IProject)projectsToConvert.get(i);
                        myConverter.addNature(project);
                    }
                } catch (CoreException e) {
                    QVTProjectPlugin.log(e);
                }
            }
        };

        try {
            getContainer().run(false, true, operation);
        } catch (InterruptedException exception) {
            QVTProjectPlugin.log(exception);
        } catch (InvocationTargetException exception) {
            QVTProjectPlugin.log(exception);
        }
        return true;
    }

        
    
    public class ConvertionPage extends WizardPage {
        public ConvertionPage() {
            super("ConvertionPage");//$NON-NLS-1$

            setTitle(QVTProjectPlugin.getResourceString("ConvertionPage.Title"));//$NON-NLS-1$
            //setDefaultPageImageDescriptor(CodeGenUIPlugin.getPlugin().getImage("full/wizban/ConvertToJETProjectWizard"));
            setDescription(QVTProjectPlugin.getResourceString("ConvertionPage.Description"));//$NON-NLS-1$
        }

        @Override
		public boolean isPageComplete() {
            return true;
        }

        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            {
                GridLayout layout = new GridLayout();
                layout.numColumns = 2;
                layout.verticalSpacing = 12;
                composite.setLayout(layout);

                GridData data = new GridData();
                data.verticalAlignment = GridData.FILL;
                data.grabExcessVerticalSpace = true;
                data.horizontalAlignment = GridData.FILL;
                composite.setLayoutData(data);
            }

            Label projectsLabel = new Label(composite, SWT.LEFT);
            projectsLabel.setText(QVTProjectPlugin.getResourceString("ConvertionPage.ProjectsListTitle"));//$NON-NLS-1$
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                projectsLabel.setLayoutData(data);
            }

            Composite selectionComposite = new Composite(composite, SWT.NONE);
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.END;
                selectionComposite.setLayoutData(data);

                RowLayout layout = new RowLayout();
                layout.justify = true;
                layout.pack = true;
                layout.spacing = 15;
                selectionComposite.setLayout(layout);
            }

            Button selectAllButton = new Button(selectionComposite, SWT.PUSH);
            selectAllButton.setText(QVTProjectPlugin.getResourceString("ConvertionPage.SelectAll"));//$NON-NLS-1$

            Button deselectAllButton = new Button(selectionComposite, SWT.PUSH);
            deselectAllButton.setText(QVTProjectPlugin.getResourceString("ConvertionPage.DeselectAll"));//$NON-NLS-1$

            Table projectsTable = new Table(composite, SWT.CHECK | SWT.BORDER);
            final CheckboxTableViewer projectsCheckboxTableViewer = new CheckboxTableViewer(projectsTable);
            {
                GridData data = new GridData();
                data.verticalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                data.grabExcessVerticalSpace = false;
                data.heightHint = 250;
                data.horizontalAlignment = GridData.FILL;
                data.horizontalSpan = 2;
                projectsTable.setLayoutData(data);
            }

            {
                TableLayout layout = new TableLayout();
                TableColumn projectColumn = new TableColumn(projectsTable, SWT.NONE);
                layout.addColumnData(new ColumnWeightData(1, true));
                projectColumn.setResizable(true);
                projectsTable.setLayout(layout);
            }

            projectsCheckboxTableViewer.setColumnProperties(new String[] { "a" }); //$NON-NLS-1$
            projectsCheckboxTableViewer.setContentProvider(new ArrayContentProvider());
            projectsCheckboxTableViewer.setLabelProvider(new LabelProvider() {
                @Override
				public Image getImage(Object o) {
                    return workbench.getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
                }

                @Override
				public String getText(Object o) {
                    return ((IProject) o).getName();
                }
            });

            projectsCheckboxTableViewer.addCheckStateListener(new ICheckStateListener() {
                public void checkStateChanged(CheckStateChangedEvent event) {
                    projectsToConvert.clear();
                    projectsToConvert.addAll(Arrays.asList((IProject[])projectsCheckboxTableViewer.getCheckedElements()));
                    setPageComplete(isPageComplete());
                }
            });

            final List<IProject> projects = new ArrayList<IProject>(Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects()));
            for (Iterator<IProject> i = projects.iterator(); i.hasNext();) {
                IProject project = i.next();
                if (!project.isOpen() || hasNature(project)) {
                    i.remove();
                }
            }
            projectsCheckboxTableViewer.setInput(projects.toArray());
            projectsCheckboxTableViewer.setCheckedElements(projectsToConvert.toArray());

            selectAllButton.addSelectionListener(new SelectionAdapter() {
                @Override
				public void widgetSelected(SelectionEvent event) {
                    projectsToConvert.addAll(projects);
                    projectsCheckboxTableViewer.setCheckedElements(projects.toArray());
                    setPageComplete(isPageComplete());
                }
            });
            deselectAllButton.addSelectionListener(new SelectionAdapter() {
                @Override
				public void widgetSelected(SelectionEvent event) {
                    projectsCheckboxTableViewer.setCheckedElements(new Object[0]);
                    projectsToConvert.clear();
                    setPageComplete(isPageComplete());
                }
            });

            setControl(composite);

            setPageComplete(isPageComplete());
        }
    }
    
    private boolean hasNature(IProject project){
        try{
            return myConverter.hasNature(project);
        }catch(CoreException e){
            QVTProjectPlugin.log(e);
        }
        return false;
    }

    private final Converter myConverter;
}
