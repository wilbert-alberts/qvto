/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonPluginImages;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.Messages;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class UniSelectTransformationControl extends Composite {
    public static interface IResourceFilter {
        boolean accept(IResource resource);
    }
    
    public static interface ISelectionListener {
        void selectionChanged(URI selectedUri);
    }

    public UniSelectTransformationControl(Composite parentComposite, IResourceFilter resourceFilter,
    		ILabelProvider transfLabelProvider, TransformationRegistry transfRegistry, TransformationRegistry.Filter transfFilter) {
        super(parentComposite,SWT.NULL);
        myResourceFilter = resourceFilter;
        mySelectionListeners = new ArrayList<ISelectionListener>();
        
        setLayout(new GridLayout());
        setLayoutData(new GridData(GridData.FILL_BOTH));
        
        List<ITreeContentProviderEx> contentProviders = new ArrayList<ITreeContentProviderEx>(2);
        contentProviders.add(WORKSPACE_CONTENT_PROVIDER);
        contentProviders.add(new CompiledTransfContentProvider());

        List<ILabelProviderEx> labelProviders = new ArrayList<ILabelProviderEx>(2);
        labelProviders.add(new LabelProviderDelegate(new WorkbenchLabelProvider()) {
			public boolean canHandle(Object element) {
				return element instanceof IResource;
			}
        });
        labelProviders.add(new LabelProviderDelegate(transfLabelProvider) {
			public boolean canHandle(Object element) {
				return element instanceof CompiledTransformation
						|| element instanceof CompiledTransformationRoot;
			}
			@Override
			public String getText(Object element) {
				if (element instanceof CompiledTransformationRoot) {
					return Messages.UniSelectTransformationControl_DeployedTransformations;
				}
				return super.getText(element);
			}
			@Override
			public Image getImage(Object element) {
				if (element instanceof CompiledTransformationRoot) {
					return CommonPluginImages.getInstance().getImage(CommonPluginImages.REGISTRY);
				}
				return super.getImage(element);
			}
        });
        
        myViewer = new TreeViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        myViewer.setContentProvider(new CompositeContentProvider(contentProviders));
        myViewer.setLabelProvider(new CompositeLabelProvider(labelProviders));
        myViewer.setAutoExpandLevel(DEFAUL_AUTO_EXPAND_LEVEL);
        myViewer.addFilter(VIEWER_FILTER);
        myViewer.setSorter(VIEWER_SORTER);
        myViewer.addSelectionChangedListener(VIEWER_LISTENER);
        
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.heightHint = 250;
        data.widthHint = 350;
        myViewer.getControl().setLayoutData(data);
        
        List<Object> inputs = new ArrayList<Object>(2);
        inputs.add(ResourcesPlugin.getWorkspace().getRoot());
        myCompiledTransformations = transfRegistry.getTransformations(transfFilter);
        inputs.add(new CompiledTransformationRoot(myCompiledTransformations));
        myViewer.setInput(inputs);


        TransformationControls.createLabel(this, Messages.UniSelectTransformationControl_CurrentSelection, TransformationControls.GRID);
        
        myFileNameText = new Text(this, SWT.BORDER);
        myFileNameText.setEnabled(false);
        myFileNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }
    
    public void addSelectionListener(ISelectionListener listener) {
        mySelectionListeners.add(listener);
    }
    
    public void removeSelectionListener(ISelectionListener listener) {
        mySelectionListeners.remove(listener);
    }
    
    public URI getSelectedUri() {
        return myUri;
    }
    
    public void selectTransformationByUri(String uriString) {
        URI uri = EmfUtil.makeUri(uriString);
        if (uri == null) {
        	return;
        }
        
		if (uri.isPlatformPlugin()) {
			for (CompiledTransformation compiledTransf : myCompiledTransformations) {
				if (compiledTransf.getUri().equals(uri)) {
		            StructuredSelection sel = new StructuredSelection(new Object[] {compiledTransf});
		            myViewer.setSelection(sel);
		            return;
				}
			}
			final String transfId = uri.toPlatformString(false).replace("/", ""); //$NON-NLS-1$ //$NON-NLS-2$
			for (CompiledTransformation compiledTransf : myCompiledTransformations) {
				if (compiledTransf.getId().equals(transfId)) {
		            StructuredSelection sel = new StructuredSelection(new Object[] {compiledTransf});
		            myViewer.setSelection(sel);
		            return;
				}
			}
		}
		else {
			IFile ifile = WorkspaceUtils.getWorkspaceFile(uri);
			if (ifile != null) {
	            StructuredSelection sel = new StructuredSelection(new Object[] {ifile});
	            myViewer.setSelection(sel);
			}
		}
    }
    
    private void fileSelectionChanged(URI selectedUri) {
        for (Iterator<ISelectionListener> it = new ArrayList<ISelectionListener>(mySelectionListeners).iterator(); it.hasNext();) {
            ISelectionListener listener = it.next();
            try {
                listener.selectionChanged(selectedUri);
            }
            catch(Exception e) {
            }
        }
    }
    
    private final ViewerFilter VIEWER_FILTER = new ViewerFilter() {
        @Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (element instanceof IContainer) {
				return hasMatchingChildrenRecursive((IContainer) element, myResourceFilter);
            }
            else if (element instanceof IResource) { 
            	return resourceMatches(myResourceFilter, (IResource) element);
            }
            else {
            	return true;
            }
        }
        
        private boolean hasMatchingChildrenRecursive(IContainer container, final IResourceFilter filter) {
            try {
				IResource[] members = container.members();
                for (IResource member : members) {
                    if (resourceMatches(filter, member)) {
                        return true;
                    }
                    
                    if(member instanceof IContainer) {
                    	boolean has = hasMatchingChildrenRecursive((IContainer) member, filter);
                    	if(has) {
                    		return true;
                    	}
                    }
                }
            } 
            catch (Exception e) {
            }
            
            return false;
        }

		private boolean resourceMatches(final IResourceFilter filter, IResource member) {
			return filter == null || filter.accept(member);
		}
    };
    
    private static final ViewerSorter VIEWER_SORTER = new ViewerSorter() {
        @Override
		public int compare(Viewer viewer, Object e1, Object e2) {
            boolean folderLeft = (e1 instanceof IContainer);
            boolean folderRight = (e2 instanceof IContainer);
            if (folderLeft == folderRight) {
                return super.compare(viewer, e1, e2);
            }
            return folderLeft ? -1 : 1;
        }
    };
    
    private final ISelectionChangedListener VIEWER_LISTENER = new ISelectionChangedListener() {
        public void selectionChanged(SelectionChangedEvent event) {
            IStructuredSelection selection = (IStructuredSelection)event.getSelection();
            
            myFileNameText.setText(""); //$NON-NLS-1$
            myUri = null;
            
            if (selection != null && selection.getFirstElement() instanceof IFile){
            	IFile ifile = (IFile) selection.getFirstElement();
                myFileNameText.setText(ifile.getName());
                myUri = URI.createPlatformResourceURI(ifile.getFullPath().toOSString(), false);
            }
            else if (selection != null && selection.getFirstElement() instanceof CompiledTransformation){
            	CompiledTransformation transf = (CompiledTransformation) selection.getFirstElement();
                myUri = transf.getUri();
                myFileNameText.setText(myUri.toString());
            }
            
            fileSelectionChanged(myUri);
        }
    };
    
    
    private TreeViewer myViewer;
    private Text myFileNameText;
    private final IResourceFilter myResourceFilter;
    private URI myUri;
    private final List<CompiledTransformation> myCompiledTransformations;
    
    private final List<ISelectionListener> mySelectionListeners;
    
    private static final int DEFAUL_AUTO_EXPAND_LEVEL = 2;
    
    private static interface ITreeContentProviderEx extends ITreeContentProvider {
    	boolean canHandle(Object element);
    }
    
    private static class CompositeContentProvider implements ITreeContentProvider {
    	CompositeContentProvider(List<ITreeContentProviderEx> providers) {
    		myProviders = providers;
    	}

		public Object[] getChildren(Object parentElement) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(parentElement)) {
					return provider.getChildren(parentElement);
				}
			}
			return null;
		}

		public Object getParent(Object element) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getParent(element);
				}
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.hasChildren(element);
				}
			}
			return false;
		}

		public Object[] getElements(Object inputElement) {
            if (inputElement instanceof List<?>) {
                return ((List<?>)inputElement).toArray();
            }
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(inputElement)) {
					return provider.getChildren(inputElement);
				}
			}
			return null;
		}

		public void dispose() {
			for (ITreeContentProviderEx provider : myProviders) {
				provider.dispose();
			}
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			for (ITreeContentProviderEx provider : myProviders) {
				if (provider.canHandle(oldInput) || provider.canHandle(newInput)) {
					provider.inputChanged(viewer, oldInput, newInput);
				}
			}
		}
    	
		private final List<ITreeContentProviderEx> myProviders;
    }

    private static interface ILabelProviderEx extends ILabelProvider {
    	boolean canHandle(Object element);
    }
    
    private static class CompositeLabelProvider implements ILabelProvider {
    	CompositeLabelProvider(List<ILabelProviderEx> providers) {
    		myProviders = providers;
    	}

		public Image getImage(Object element) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getImage(element);
				}
			}
			return null;
		}

		public String getText(Object element) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.getText(element);
				}
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {
			for (ILabelProviderEx provider : myProviders) {
				provider.addListener(listener);
			}
		}

		public void dispose() {
			for (ILabelProviderEx provider : myProviders) {
				provider.dispose();
			}
		}

		public boolean isLabelProperty(Object element, String property) {
			for (ILabelProviderEx provider : myProviders) {
				if (provider.canHandle(element)) {
					return provider.isLabelProperty(element, property);
				}
			}
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			for (ILabelProviderEx provider : myProviders) {
				provider.removeListener(listener);
			}
		}

		private final List<ILabelProviderEx> myProviders;
    }
    
    private ITreeContentProviderEx WORKSPACE_CONTENT_PROVIDER = new ITreeContentProviderEx() {
        
        public Object[] getChildren(Object parentElement) {
            return myProvider.getChildren(parentElement);
        }
        
        public Object getParent(Object element) {
            Object parent = myProvider.getParent(element);
            if (parent != null) {
                return parent;
            }
            
            if (element instanceof IFile == false) {
                return null;
            }
            
            IFile file = (IFile) element;
            return file.getParent();
        }

        public boolean hasChildren(Object element) {
            return myProvider.hasChildren(element);
        }

        public Object[] getElements(Object inputElement) {
            return myProvider.getElements(inputElement);
        }

        public void dispose() {
            myProvider.dispose();
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            myProvider.inputChanged(viewer, oldInput, newInput);
        }

		public boolean canHandle(Object element) {
			return element instanceof IResource;
		} 

        private final ITreeContentProvider myProvider = new WorkbenchContentProvider();
    };

    private static abstract class LabelProviderDelegate implements ILabelProviderEx {
    	LabelProviderDelegate(ILabelProvider provider) {
    		myDelegate = provider;
    	}

		public Image getImage(Object element) {
			return myDelegate.getImage(element);
		}

		public String getText(Object element) {
			return myDelegate.getText(element);
		}

		public void addListener(ILabelProviderListener listener) {
			myDelegate.addListener(listener);
		}

		public void dispose() {
			myDelegate.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myDelegate.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myDelegate.removeListener(listener);
		}
		
		private final ILabelProvider myDelegate;
    };
    
    private static class CompiledTransformationRoot {
    	CompiledTransformationRoot(List<CompiledTransformation> trasformations) {
    		myTrasformations = trasformations;
    	}
    	
    	Object[] getChildren() {
    		return myTrasformations.toArray();
    	}
    	
    	private final List<CompiledTransformation> myTrasformations;
    }
    
    private static class CompiledTransfContentProvider implements ITreeContentProviderEx {
    	
        public Object[] getChildren(Object parentElement) {
            return getElements(parentElement);
        }

        public Object getParent(Object element) {
            return null;
        }

        public boolean hasChildren(Object element) {
            Object[] children = getChildren(element);
            return children.length > 0;
        }

        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof CompiledTransformationRoot) {
                return ((CompiledTransformationRoot) inputElement).getChildren();
            }
            else {
                return new Object[0];
            }
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

		public boolean canHandle(Object element) {
			return element instanceof CompiledTransformation 
					|| element instanceof CompiledTransformationRoot;
		}
    };

}
