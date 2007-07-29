package org.eclipse.m2m.qvt.oml.project.builder;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class Decorator extends LabelDecorator {

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image decorateImage(Image image, Object element,
			IDecorationContext context) {
		return decorateImage(image, element);
	}

	public Image decorateImage(Image image, Object element) {
		return null;//new WorkbenchLabelProvider().getImage(element);//PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}

	@Override
	public String decorateText(String text, Object element,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return decorateText(text, element);
	}

	public String decorateText(String text, Object element) {
		// TODO Auto-generated method stub
		return text + " - rada";
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText,
			IDecorationContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

}
