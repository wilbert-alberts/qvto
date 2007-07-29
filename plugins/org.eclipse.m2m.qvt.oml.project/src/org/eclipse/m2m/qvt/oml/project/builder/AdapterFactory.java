package org.eclipse.m2m.qvt.oml.project.builder;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IActionFilter;

public class AdapterFactory implements IAdapterFactory {

	public AdapterFactory() {
		// TODO Auto-generated constructor stub
	}	
	
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(IActionFilter.class.equals(adapterType)) {
			return new Filter();			
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class[] { IActionFilter.class };
	}

	public static class Adaptable implements IAdaptable {

		public Object getAdapter(Class adapter) {		
			return new Filter();
		}
		
	}
	
	static class Filter implements IActionFilter {
		public boolean testAttribute(Object target, String name, String value) {
			return true;
		}
	}
}
