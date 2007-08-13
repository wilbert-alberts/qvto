package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;

public class UriGroupInOut extends UriGroupIn {

    public UriGroupInOut(Composite parent, String name) {
    	super(parent, name);
    }
    
	public IValidator getValidator() {
		if (myValidator == null) {
			myValidator = new ValidatorInOut();
		}
		return myValidator;
	}

	class ValidatorInOut extends Validator {

		public IStatus validate(IModelParameterInfo paramInfo) {
			IStatus result = super.validate(paramInfo);
			if (result.getSeverity() >= IStatus.WARNING) {
				return result;
			}

			URI sourceUri = EmfUtil.makeUri(getText());
        	String uriPath = sourceUri.isFile() ? sourceUri.toFileString() :
    			(sourceUri.isPlatform() ? sourceUri.toPlatformString(true) : sourceUri.toString());
        	IFile file = WorkspaceUtils.getWorkspaceFile(uriPath);
        	if (file != null && file.exists() && file.isReadOnly()) {
                if (result.getSeverity() < IStatus.WARNING) {
                	result = StatusUtil.makeWarningStatus(NLS.bind(Messages.QvtValidator_DestinationReadonly, sourceUri));
                }
        	}
			
			return result;
		}
    }
    
}
