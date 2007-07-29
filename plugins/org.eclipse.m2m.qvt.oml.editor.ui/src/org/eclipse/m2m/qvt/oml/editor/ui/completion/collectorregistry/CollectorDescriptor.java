package org.eclipse.m2m.qvt.oml.editor.ui.completion.collectorregistry;

import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.m2m.qvt.oml.editor.ui.completion.ICollector;

public class CollectorDescriptor {
	private final CategoryDescriptor myCategoryDescriptor;
	private final ICollector myCollector;
	
	public CollectorDescriptor(String category, String clazz, IConfigurationElement configurationElement) {
		CategoryDescriptor selectedCategoryDescriptor = null;
		for (CategoryDescriptor categoryDescriptor : CollectorRegistry.getCategories()) {
			if (category.equals(categoryDescriptor.getId())) {
				selectedCategoryDescriptor = categoryDescriptor;
				break;
			}
		}
		if (selectedCategoryDescriptor == null) {
			throw new RuntimeException(MessageFormat.format("Category {0} not found!",  //$NON-NLS-1$
					new Object[] {category}));
		}
		myCategoryDescriptor = selectedCategoryDescriptor;
		ICollector collector = null;
		try {
			collector = (ICollector) configurationElement.createExecutableExtension(clazz);
		} catch (CoreException exception) {
			throw new RuntimeException(exception);
		}
		myCollector = collector;
	}

	public CategoryDescriptor getCategoryDescriptor() {
		return myCategoryDescriptor;
	}

	public ICollector getCollector() {
		return myCollector;
	}
}
