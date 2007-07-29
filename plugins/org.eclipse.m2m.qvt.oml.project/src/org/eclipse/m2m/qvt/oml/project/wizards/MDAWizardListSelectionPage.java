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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.m2m.qvt.oml.project.INewTransformationWizard;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPlugin;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;


/**
 * This wizard page is provides a mechanism for selecting one of available
 * MDA wizards applicable within MDA project which is used for further
 * navigation in the containing wizard. 
 */
public class MDAWizardListSelectionPage extends WizardSelectionPage implements ISelectionChangedListener {	

	private static final String POINT_NAMESPACE = "org.eclipse.ui"; //$NON-NLS-1$
	private static final String POINT_NAME = "newWizards"; //$NON-NLS-1$
	private static final String ID_PREFIX = "org.eclipse.m2m.qvt.oml."; //$NON-NLS-1$
	private static final String ID_ATTR = "id"; //$NON-NLS-1$
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$
	
	private static final String ICON_ATTR = "icon"; //$NON-NLS-1$
	private static final String NAME_ATTR = "name"; //$NON-NLS-1$
	private static final String DESC_TAG = "description"; //$NON-NLS-1$

	private TableViewer myWizardSelectionViewer;
	private Button myUseTransformation;
	private WizardElement myOldSelectedWizardElement;
	private Text myDescriptionText;
	private MDAProjectFieldData myProjectData;

	
	public MDAWizardListSelectionPage(MDAProjectFieldData projectData) {
		super(MDAWizardListSelectionPage.class.getSimpleName());
		setTitle(MDAProjectPlugin.getResourceString("WizardListSelectionPage.title")); //$NON-NLS-1$
		setDescription(getWizardListPageDescription()); //$NON-NLS-1$
		this.myProjectData = projectData;
	}

    @Override
    public boolean canFlipToNextPage() {
        if (myUseTransformation.getSelection() && getSelectedNode() == null) {
            return false;
        }
        if (validate() != null) {
            return false;
        }
        return super.canFlipToNextPage();
    } 
		
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 10;
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createTransormationCheckBtn(container, 1);
		
		Label label = new Label(container, SWT.NONE);
		label.setText(MDAProjectPlugin.getResourceString("WizardListSelectionPage.message"));
		GridData gd = new GridData();
		label.setLayoutData(gd);
		
		SashForm sashForm = new SashForm(container, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 300;
		sashForm.setLayoutData(gd);
		
		myWizardSelectionViewer = new TableViewer(sashForm, SWT.BORDER);
		myWizardSelectionViewer.setContentProvider(new ArrayContentProvider());
		myWizardSelectionViewer.setLabelProvider(new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				return ((WizardElement)element).image;
			}
			
			@Override
			public String getText(Object element) {
				return ((WizardElement)element).name;
			}
		});
		
		myWizardSelectionViewer.setComparator(new NameComparator());
		
		myWizardSelectionViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				selectionChanged(new SelectionChangedEvent(myWizardSelectionViewer, myWizardSelectionViewer.getSelection()));				
				getContainer().showPage(getNextPage());
			}
		});
		
		this.myDescriptionText = new Text(sashForm, SWT.BORDER);
		GridData descGD = new GridData(GridData.FILL_BOTH);
		descGD.widthHint = 200;
		myDescriptionText.setLayoutData(descGD);		
		
		myWizardSelectionViewer.setInput(getAvailableTransformationWizards());
		myWizardSelectionViewer.addSelectionChangedListener(this);
		
		Dialog.applyDialogFont(container);
		setControl(container);
		
		setSelectionToViewer();
		updateControl();
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, 
			"org.eclipse.m2m.qvt.oml.transformation_project"); //$NON-NLS-1$		
	}
	
    @Override
	public boolean isPageComplete() {
        setErrorMessage(validate());
        return !myUseTransformation.getSelection();
    }
    
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			myUseTransformation.setFocus();
		}
	}    
    				
	public void selectionChanged(SelectionChangedEvent event) {
		setErrorMessage(null);
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		WizardElement currentWizardSelection = null;
		Iterator iter = selection.iterator();
		if (iter.hasNext())
			currentWizardSelection = (WizardElement) iter.next();
		if (currentWizardSelection == null) {
			myDescriptionText.setText(""); //$NON-NLS-1$
			setSelectedNode(null);
			return;
		}
		final WizardElement finalSelection = currentWizardSelection;
		setSelectedNode(new WizardNode(finalSelection));
		myDescriptionText.setText(finalSelection.description);
		getContainer().updateButtons();
	}	
	
	protected void createTransormationCheckBtn(Composite container, int span) {
		myUseTransformation = new Button(container, SWT.CHECK);
		myUseTransformation.setText(MDAProjectPlugin.getResourceString("WizardListSelectionPage.label")); //$NON-NLS-1$
		GridData gd = new GridData();
		gd.horizontalSpan = span;
		myUseTransformation.setLayoutData(gd);
		myUseTransformation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateControl();
			}
		});
		myUseTransformation.setSelection(false);
	}	
	
	protected IPluginContentWizard getSelectedWizard() {
		IWizardNode node = getSelectedNode();
		if (node != null)
			return (IPluginContentWizard)node.getWizard();
		return null;
	}	
	
	private void updateControl() {
		if (!myUseTransformation.getSelection()) {
			IStructuredSelection selection = (IStructuredSelection)myWizardSelectionViewer.getSelection();
			myOldSelectedWizardElement = (WizardElement)selection.getFirstElement();
		}
		setSelectionToViewer();
		myWizardSelectionViewer.getControl().setEnabled(myUseTransformation.getSelection());
		myDescriptionText.setEnabled(myUseTransformation.getSelection());	
		if (myUseTransformation.getSelection()) {
			myWizardSelectionViewer.getControl().forceFocus();
		}
	}	
	
	@SuppressWarnings("unchecked")
	private void setSelectionToViewer() {
		if (myUseTransformation.getSelection()) {
			List<WizardElement> input = (List<WizardElement>)myWizardSelectionViewer.getInput();			
			WizardElement welement = null; 
			if (myOldSelectedWizardElement != null) {
				welement = myOldSelectedWizardElement;
			} else if (!input.isEmpty()) {
				welement = input.get(0);
			}
			
			if (welement != null) {
				myWizardSelectionViewer.setSelection(new StructuredSelection(welement));
				setSelectedNode(new WizardNode(welement));

				myDescriptionText.setText(welement.description);
			}
		} else {
			myWizardSelectionViewer.setSelection(new StructuredSelection());
			setSelectedNode(null);
			myDescriptionText.setText(""); //$NON-NLS-1$
		}
	}		
	
	private List<WizardElement> getAvailableTransformationWizards() {
		List<WizardElement> wizards = new ArrayList<WizardElement>(); //$NON-NLS-1$
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(POINT_NAMESPACE, POINT_NAME);
		if (point == null) {
			return wizards;
		}
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				IConfigurationElement element = elements[j];
				Bundle bundle = Platform.getBundle(element.getNamespaceIdentifier());				
				String id = element.getAttribute(ID_ATTR);

				if (id != null && id.startsWith(ID_PREFIX) && 
					WizardElement.isWizardClass(bundle, element.getAttribute(CLASS_ATTR))) {
					wizards.add(new WizardElement(element));
				}
			}
		}

		return wizards;
	}	
	
    /**
     * @return error message
     */
    private String validate() {
        String result = null;
        if (myUseTransformation.getSelection() && !myProjectData.isPlugin()) {
            IPluginContentWizard selectedWizard = getSelectedWizard();
            if (selectedWizard instanceof INewTransformationWizard) {
                INewTransformationWizard newTransWizard = (INewTransformationWizard) selectedWizard;
                if (newTransWizard.isJavaRequired()) {
                    result = MDAProjectPlugin.getResourceString("MDAWizardListSelectionPage.PluginRequired", new Object[] {newTransWizard.getWindowTitle()}); //$NON-NLS-1$
                }
            }
        }
        return result;
    }
    
	private static String getWizardListPageDescription() {
		return MDAProjectPlugin.getResourceString("WizardListSelectionPage.desc");		
	}    
    	
	private static class WizardElement {
		IConfigurationElement configurationElement;
		Image image;
		String name;
		String description;
				
		WizardElement(IConfigurationElement element) {
			assert element != null;
			this.configurationElement = element;
			
			Bundle bundle = Platform.getBundle(element.getNamespaceIdentifier());			
			this.name = expandText(bundle, element.getAttribute(NAME_ATTR));
			this.description = expandText(bundle, getDescription(element));
			String imagePath = element.getAttribute(ICON_ATTR);
			if(imagePath != null && imagePath.length() > 0) {
				this.image = getImage(element.getNamespaceIdentifier(), imagePath);
			}
		}
		
		static boolean isWizardClass(Bundle bundle, String wizardClassName) {
			if(wizardClassName == null) {
				return false;
			}
			Class wizardClass = null;
			try {
				wizardClass = bundle.loadClass(wizardClassName);
			} catch (ClassNotFoundException e) {
				MDAProjectPlugin.log(e);
				return false;
			}
			return isWizardClass(wizardClass);
		}
		
		static boolean isWizardClass(Class wizardClass) {
			List<Class> interfaces = Arrays.asList(wizardClass.getInterfaces());
			if(interfaces.contains(INewTransformationWizard.class)) {
				return true;
			}
			if(wizardClass.getSuperclass() != null) {
				return isWizardClass(wizardClass.getSuperclass());
			}
			return false;
		}		
		
		INewTransformationWizard createWizard() {
			Object wizardObj = null;
			try {
				wizardObj = configurationElement.createExecutableExtension(CLASS_ATTR);
			} catch (CoreException e) {
				MDAProjectPlugin.log(e);
			}
			if (wizardObj instanceof INewTransformationWizard) {
				return (INewTransformationWizard)wizardObj;
			}
			return null;
		}
		
		void dispose() {
			if(image != null) image.dispose();
		}

		static String getDescription(IConfigurationElement wizardElement) {
			IConfigurationElement[] descElements = wizardElement.getChildren(DESC_TAG);
			return descElements.length > 0 ? descElements[0].getValue() : null;		
		}

		static Image getImage(String pluginID, String imageName) {
			ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(pluginID, imageName);
			return imageDescriptor.createImage();
		}

		static String expandText(Bundle bundle, String source) {
			if (source == null || source.length() == 0)
				return source;
			if (source.indexOf('%') == -1)
				return source;
		
			if (bundle == null)
				return source;
		
			ResourceBundle resourceBundle = Platform.getResourceBundle(bundle);
			if (resourceBundle == null)
				return source;
			StringBuffer buf = new StringBuffer();
			boolean keyMode = false;
			int keyStartIndex = -1;
			for (int i = 0; i < source.length(); i++) {
				char c = source.charAt(i);
				if (c == '%') {
					char c2 = source.charAt(i + 1);
					if (c2 == '%') {
						i++;
						buf.append('%');
						continue;
					}
					if (keyMode) {
						keyMode = false;
						String key = source.substring(keyStartIndex, i);
						String value = key;
						try {
							value = resourceBundle.getString(key);
						} catch (MissingResourceException e) {
						}
						buf.append(value);
					} else {
						keyStartIndex = i + 1;
						keyMode = true;
					}
				} else if (!keyMode) {
					buf.append(c);
				}
			}
			return buf.toString();
		}
	}
	
	private class WizardNode implements IWizardNode {
		WizardElement myWizardElement;
		INewTransformationWizard myWizard;

		public WizardNode(WizardElement element) {
			assert element != null;
			myWizardElement = element;
		}
		
		public void dispose() {
			if (myWizardElement != null) {
				myWizardElement.dispose();	
			}
		}

		public Point getExtent() {
			return new Point(-1, -1);
		}

		public IWizard getWizard() {
			if (!myUseTransformation.getSelection()) {
				return null;
			}

			if (myWizard == null && getSelectedNode() != null) {
				myWizard = myWizardElement.createWizard();
				
				IProject projectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(myProjectData.getProjectName());
				myWizard.init(PlatformUI.getWorkbench(), new StructuredSelection(projectHandle));
				
				myWizard.setProjectFieldData(myProjectData);
				myWizard.addPages();
				return myWizard;
			}
			return myWizard;
		}

		public boolean isContentCreated() {
			return ((INewTransformationWizard) getWizard()).isContentCreated();
		}
	}
	
	private static class NameComparator extends ViewerComparator {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			WizardElement w1 = (WizardElement)e1;
			WizardElement w2 = (WizardElement)e2;
			return safeName(w1).compareTo(safeName(w2));
		}
		
		static String safeName(WizardElement we) {
			return we.name != null ? we.name : ""; //$NON-NLS-1$
		}
	}
}
