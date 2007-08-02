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
package org.eclipse.m2m.qvt.oml.ui.wizards;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.qvt.oml.QvtNamesChecker;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.project.QvtProjectUtil;
import org.eclipse.m2m.qvt.oml.project.model.IQvtCompilationUnit;
import org.eclipse.m2m.qvt.oml.project.model.IQvtElement;
import org.eclipse.m2m.qvt.oml.project.model.IQvtNamespace;
import org.eclipse.m2m.qvt.oml.project.model.IQvtProject;
import org.eclipse.m2m.qvt.oml.project.model.QvtModelException;
import org.eclipse.m2m.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.undo.CreateFolderOperation;

/**
 * @author dvorak
 */
public class NewQvtModuleCreationPage extends WizardPage implements Listener {
		
    private IStatus fStatus;
	private IPath fContainerPath;	
    private boolean fIsLockedToInitialContainer;
    private boolean fWasEverShown = false;    
    
	private Text fModuleNameField;
	private Text fContainerField;
	private Text fNameSpaceField;


    public NewQvtModuleCreationPage(IPath lockedContainerPath) {
        super("QVT module creation"); //$NON-NLS-1$
        
        fContainerPath = lockedContainerPath;
        fStatus = Status.OK_STATUS;
        fIsLockedToInitialContainer = fContainerPath != null;
    }
    
    public NewQvtModuleCreationPage() {
    	this(null);
    }
    
        
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);

        int nColumns = fIsLockedToInitialContainer ? 3 : 4;
        GridLayout layout = new GridLayout();
		layout.numColumns = nColumns;

        composite.setLayout(layout);

                
        // container path
        Label containerLabel = new Label(composite, SWT.NONE);
        containerLabel.setText(Messages.NewQvtModuleCreationPage_sourceContainerFieldLabel);
                        
        fContainerField = new Text(composite, SWT.BORDER);
        fContainerField.addListener(SWT.Modify, this);
        GridData containerData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
        containerData.horizontalSpan = 2;
        fContainerField.setLayoutData(containerData);

        if(!fIsLockedToInitialContainer) {        	
	        Button browseSrcContainerBtn = new Button(composite, SWT.NONE);
	        browseSrcContainerBtn.setText(Messages.NewQvtModuleCreationPage_browseButtonLabel);
	        browseSrcContainerBtn.addSelectionListener(new SelectionAdapter() {
	        	@Override        	
	        	public void widgetSelected(SelectionEvent e) {
	        		IContainer sourceContainer = SourceDestinationChooser.chooseSourceContainer(getShell(), null);
	        		if(sourceContainer != null) {
	        			fContainerField.setText(sourceContainer.getFullPath().toString());
	        		}
	        	} 
	        });
        } else {
            fContainerField.setEnabled(false);
        }
        
        // compilation unit name-space field
        Label namespaceLabel = new Label(composite, SWT.NONE);
        namespaceLabel.setText(Messages.NewQvtModuleCreationPage_namespaceFieldLabel);
        namespaceLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

        fNameSpaceField = new Text(composite, SWT.BORDER);
        fNameSpaceField.addListener(SWT.Modify, this);
        fNameSpaceField.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        
        final Label defaultLabel = new Label(composite, SWT.NONE);
        defaultLabel.setText(Messages.NewQvtModuleCreationPage_defaultNamespaceLabel);
        defaultLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

        fNameSpaceField.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {        	
        		String text = fNameSpaceField.getText();
        		if(text == null || text.length() == 0) {
        			defaultLabel.setVisible(true);
        		} else {
        			defaultLabel.setVisible(false);
        		}
        	}
        });        
        
        if(!fIsLockedToInitialContainer) {
	        Button browseNamespaceBtn = new Button(composite, SWT.NONE);
	        browseNamespaceBtn.setText(Messages.NewQvtModuleCreationPage_browseButtonLabel);
	        browseNamespaceBtn.addSelectionListener(new SelectionAdapter() {
	        	@Override
	        	public void widgetSelected(SelectionEvent e) {
	        		IQvtNamespace namespace = SourceDestinationChooser.chooseNamespaceFolder(getShell());
	        		if(namespace != null) {
	            		fNameSpaceField.setText(namespace.getQualifiedName());
	        			// compute source container
	            		try {
							String srcPath = namespace.getQvtProject().getQvtSourceContainerPath().toString();
							fContainerField.setText(srcPath);
						} catch (QvtModelException exc) {
							QVTUIPlugin.log(exc);
						}            		
	        		}
	        	} 
	        });
        }

        // module name         
        Label nameLabel = new Label(composite, SWT.NONE);
        nameLabel.setText(Messages.NewQvtModuleCreationPage_moduleNameFieldLabel);
		nameLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

        fModuleNameField = new Text(composite, SWT.BORDER);
		fModuleNameField.addListener(SWT.Modify, this); 
		GridData nameGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		nameGridData.horizontalSpan = 1;		
        fModuleNameField.setLayoutData(nameGridData);
        
        // final initialization
        performInitialSettings();
                                      
        Dialog.applyDialogFont(composite);

        setPageComplete(false);
        setControl(composite);
    }
    
    protected void performInitialSettings() {
    	if(fIsLockedToInitialContainer) {
    		if(fContainerPath != null) {
    			fContainerField.setText(fContainerPath.toString());
    		}
    	}
    	
        IQvtElement initialContext = findInitialQvtProjectScopeContext();
        if(initialContext != null) {
		    String initialNamespace = computeInitialNamespace(initialContext);
		    if(initialNamespace != null) {
		    	fNameSpaceField.setText(initialNamespace);
		    } 
		    
		    String initialContainer = computeInitialSourceContainer(initialContext);
		    if(initialContainer != null) {
		    	fContainerField.setText(initialContainer);
		    }
        }
        
        // perform correcting suggestions
        String resultName = performProposedNameCorrections(getNewModuleNameProposal());
        assert resultName != null;
        
        if(resultName != null) {
        	fModuleNameField.setText(resultName); 
        }
    }
        
    public void handleEvent(Event event) {
    	if(event.type == SWT.Modify) {
    		validatePage();
    		
    		if(isValid()) {
    			IContainer container = getNamespaceContainer(); 
    			fContainerPath = ((container != null) ? container.getFullPath() : null);    			
    		} else {
    			fContainerPath = null;    			
    		}
    	}
    }
    
    /**
	 * Gets the QVT module name value set in the wizard.
	 * 
	 * @return the module name
	 */
    public final String getModuleName() {
    	return getModuleNameValue();
    }
    
    protected String getModuleNameValue() {
    	return (fModuleNameField != null) ? fModuleNameField.getText() : null;
    }
    
    protected String getNewModuleNameProposal() {    	
    	return Messages.NewQvtModuleCreationPage_newModuleNameProposal;
    }
    
    protected final void validatePage() {
    	IStatus[] result = doValidatePage();    	
    	updateStatus(result);
    }

	final protected void updateStatus(IStatus[] result) {
		// select most sever status
    	fStatus = Status.OK_STATUS;
    	for (IStatus status : result) {
    		if(status.getSeverity() > fStatus.getSeverity()) {
    			fStatus = status;
    		}
		}

    	if(!fStatus.isOK()) {
    		int type = IMessageProvider.NONE;
    		switch (fStatus.getSeverity()) {
			case IStatus.ERROR:
				type = IMessageProvider.ERROR;
				break;
			case IStatus.WARNING:
				type = IMessageProvider.WARNING;
				break;
			case IStatus.INFO:
				type = IMessageProvider.INFORMATION;
				break;
			}

        	setMessage(fStatus.getMessage(), type);
        	setPageComplete(isValid());
        	setPageComplete(true);
        	
    	} else {
    		setErrorMessage(null);
    		setMessage(null);
    		
    		setPageComplete(true);
    	}
	}
    
    protected IStatus[] doValidatePage() {
    	return new IStatus[] {
				doValidateSourceContainer(),
				doValidateNamespace(),
    			doValidateModuleName()
    	};
    }
    
    protected IStatus doValidateModuleName() {
    	IStatus status = QvtNamesChecker.validateQvtModuleIdentifier(getModuleNameValue());
    	if(status.isOK()) {
    		// check if already exist at given source container
    		IQvtProject qvtProject = getTargetQvtProject(); 
    		if(qvtProject != null && qvtProject.getProject().exists()) {
    			if(doValidateNamespace().isOK()) {
    				String unitQualifiedName = getNewModuleQualifiedName();
					try {
						IQvtCompilationUnit existingCU = qvtProject.findCompilationUnit(unitQualifiedName);
	        			if(existingCU != null) {
	        				String message = Messages.NewQvtModuleCreationPage_moduleAlreadyExists;
	        				return QVTUIPlugin.createStatus(IStatus.ERROR, NLS.bind(message, unitQualifiedName));
	        			} 						
					} catch (QvtModelException e) {
						QVTUIPlugin.log(e);
					}
    			}
    		}
    	}
    	
    	return status;
    }
    
    private IQvtProject getTargetQvtProject() {
		if(!doValidateSourceContainer().isOK()) {
			return null;
		}
    	
    	IContainer srcContainer = getSourceContainer();
    	if(srcContainer != null) {
    		IProject project = srcContainer.getProject();
    		if(project.exists()) {
    			return QvtProjectUtil.getQvtProject(project);
    		}
    	}
    	
    	return null;
	}
    
    protected String getNewModuleQualifiedName() {
		String unitQualifiedName = null;
		String nsValue = getNamespaceValue();
		if(nsValue != null && nsValue.length() > 0) {
			unitQualifiedName = getNamespaceValue() +  QvtNamesChecker.QNAME_DELIMITER + getModuleNameValue();
		} else {
			unitQualifiedName = getModuleNameValue();
		}
		
		return unitQualifiedName;
    }
    
    protected boolean isValid() {
    	return fStatus.getSeverity() <= IStatus.WARNING;
    }
    
    @Override
    public boolean isPageComplete() {
        return fWasEverShown && super.isPageComplete() && isValid();
    }
    
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            fWasEverShown = true;
        }
        
        fModuleNameField.forceFocus();
        fModuleNameField.selectAll();
        validatePage();
    }
    
    protected String computeInitialNamespace(IQvtElement context) {
    	IQvtNamespace namespace = null;
    	if(context != null) {
    		final int type = context.getElementType();
    		if(type == IQvtElement.QVT_COMPILATION_UNIT) {
    			IQvtCompilationUnit cu = (IQvtCompilationUnit) context;
    			namespace = cu.getNamespace();
    		} else if(type == IQvtElement.QVT_NAMESPACE) {
    			namespace = (IQvtNamespace) context;
    		} else if(type == IQvtElement.QVT_PROJECT) {
    			// choose a default name-space
    			try {
					namespace = ((IQvtProject)context).getDefaultNamespace();
				} catch (QvtModelException e) {
					QVTUIPlugin.log(e);
				}
    		}
    	}

    	return (namespace != null) ? namespace.getQualifiedName() : null;
    }
    
    protected String computeInitialSourceContainer(IQvtElement context) {
    	if(fIsLockedToInitialContainer) {
    		if(fContainerPath == null) {
    			return null;
    		}
    		return fContainerPath.toString();
    	}
    	
    	try {
			return context.getQvtProject().getQvtSourceContainerPath().toString();
		} catch (QvtModelException e) {
			QVTUIPlugin.log(e);
		}
		return null;
    }
    
    protected IQvtElement computeInitialQvtElement(IResource context) {
    	if(!context.exists()) {
    		return null;
    	}
    	
    	IQvtProject qvtProject = QvtProjectUtil.getQvtProject(context.getProject());
    	IQvtElement qvtElement = null;
    	if(qvtProject != null) {
			try {
	    		qvtElement = qvtProject.findElement(context, false);				
			} catch (QvtModelException e) {
				IStatus status = QVTUIPlugin.createStatus(IStatus.ERROR, "Failed to compute intial namespace", e); //$NON-NLS-1$
				QVTUIPlugin.log(status);
			}
    	}
    	
    	return qvtElement;
    }   
    
    protected IQvtElement findInitialQvtProjectScopeContext() {
    	if(PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null) {
    		return null;
    	}
    	
    	IQvtElement context = null;
    	IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	
    	IEditorPart editorPart = activePage.getActiveEditor();
    	if(editorPart != null && editorPart.getEditorInput() != null) {
    		IResource resource = (IResource)editorPart.getEditorInput().getAdapter(IResource.class);
    		if(resource != null && QvtProjectUtil.isQvtProject(resource.getProject())) {
    			context = computeInitialQvtElement(resource);
    		}
    	}
    	 
    	if(context != null) {
    		return context;
    	}
    	
    	if(activePage.getActivePart() instanceof IViewPart) {
    		IWorkbenchPartSite site = activePage.getActivePart().getSite();
    		if(site.getSelectionProvider() != null) {
    			ISelection selection = site.getSelectionProvider().getSelection();
    			if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
    				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
    				for (Iterator<?> it = structuredSelection.iterator(); it.hasNext();) {
						Object nextElement = it.next();
						if(nextElement instanceof IAdaptable) {
							IResource resource = (IResource)((IAdaptable)nextElement).getAdapter(IResource.class);
							if(resource != null && QvtProjectUtil.isQvtProject(resource.getProject())) {
								if((context = computeInitialQvtElement(resource)) != null) {
									break;
								}
							}
						}
					}
    			}
    		}
    	}
    	
    	if(context == null) {
	    	// no contextual selection has been deduced, try selecting the first QVT project in workspace
	    	for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
	    		IQvtProject qvtProject = QvtProjectUtil.getQvtProject(project);
				if(qvtProject != null) {
					return qvtProject;
				}
			}
    	}
    	
    	return context;
    }
    
    protected String getSourceContainerValue() {
    	return (fContainerField != null) ? fContainerField.getText() : null;
    }
    
    protected String getNamespaceValue() {
    	return (fNameSpaceField != null) ? fNameSpaceField.getText() : null;
    }
    
    protected IStatus doValidateSourceContainer() {
    	IStatus status = validateSourceContainerPath(getSourceContainerValue());
    	if(status.isOK()) {
    		IContainer container = getSourceContainer();
    		if(container != null) {
    			if(!fIsLockedToInitialContainer && !container.exists()) {
    				String message = NLS.bind(Messages.NewQvtModuleCreationPage_sourceContainerDoesNotExist, container.getFullPath().toString());
    				status = QVTUIPlugin.createStatus(IStatus.ERROR, message, null);
    			}
    		}
    	}
    	return status;
    }
    
    public IFile getNewModuleFileHandle() {
    	IContainer container = getNamespaceContainer();
    	IPath path = container.getFullPath().append(getModuleNameValue() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
    	return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    }
    
    public IFile createNewFile(String contents) {
    	IFile file = getNewModuleFileHandle();
    	// ensure path exists
    	IContainer container = file.getParent(); 
    	if(!container.exists() && container.getType() == IResource.FOLDER) {
    		CreateFolderOperation folder = new CreateFolderOperation((IFolder) container, null, "Create container"); //$NON-NLS-1$
    		try {
				folder.execute(null, null);
			} catch (ExecutionException e) {
				QVTUIPlugin.log(e);
			}
    	}
    	
    	try {
			file.create(new ByteArrayInputStream(contents.getBytes()), true, null);
		} catch (CoreException e) {
			QVTUIPlugin.log(e.getStatus());
		}
    	
    	return file;
    }
    
    protected IStatus doValidateNamespace() {
    	String namespace = getNamespaceValue();
    	if(namespace == null || namespace.length() == 0) {
    		// fine for default name-space
    		return Status.OK_STATUS;
    	}
    	return QvtNamesChecker.validateNamespaceQualifiedIdentifier(namespace);
    }
    
    protected IContainer getSourceContainer() {
    	String sourceContainerFullPath = getSourceContainerValue();

    	IWorkspace ws = ResourcesPlugin.getWorkspace();
    	IStatus pathStatus = ws.validatePath(sourceContainerFullPath, IResource.PROJECT | IResource.FOLDER);
    	if(pathStatus.isOK()) {    		
        	IPath path = new Path(sourceContainerFullPath);
        	if(path.segmentCount() == 1) {
        		return ws.getRoot().getProject(path.segment(0));        		
        	} else if(path.segmentCount() > 1) {
        		return ws.getRoot().getFolder(path);
        	}
    	}
    	
    	return null;
    }
    
	private String performProposedNameCorrections(final String proposedName) {		
		return new NamesInScopeChecker() {
        	@Override
        	protected void doDefine(String newName) {
        		// nothing as it is defined in the work-space
        	}        
        	@Override
        	protected boolean isDefined(String newName) {
				try {
		    		IQvtProject qvtProject = getTargetQvtProject();
		    		if(qvtProject != null && qvtProject.getProject().exists()) {
		    			fModuleNameField.setText(newName);

						String unitQualifiedName = getNewModuleQualifiedName();
						if(!QvtNamesChecker.validateQvtModuleIdentifier(proposedName).isOK()) {
							return false;
						}
						
		    			IQvtCompilationUnit existingCU = qvtProject.findCompilationUnit(unitQualifiedName);
		    			return existingCU != null;
		    		}
				} catch (QvtModelException e) {
					QVTUIPlugin.log(e);
				}
        		
        		return false;
        	}
        }.checkedDefineName(proposedName);
	}
    

	private IContainer getNamespaceContainer() {
		if(!doValidateSourceContainer().isOK()) {
			return null;
		}
		
		IContainer srcContainer = getSourceContainer();
		if(srcContainer == null) {
			// can't deduce name-space container if there is no source container
			return null;
		}
				
		String namespace = getNamespaceValue();		
		if(namespace == null || namespace.length() == 0) {
			return srcContainer;
		}

		IStatus status = doValidateNamespace();
		if(!status.isOK()) {
			return null;
		}
		// now we can safely convert nsQname to relative path
		IPath nsPath = new Path(namespace.replace('.', '/'));
		return srcContainer.getFolder(nsPath);
    }
	
	static IStatus validateSourceContainerPath(String path) {
		if(path == null || path.trim().length() == 0) {
			return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.NewQvtModuleCreationPage_sourceContainerPathMustBeSpecified, null);
		}

		return ResourcesPlugin.getWorkspace().validatePath(path, IResource.PROJECT | IResource.FOLDER);
	}
}
