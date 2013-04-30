package org.eclipse.m2m.internal.tests.qvt.oml.debugger;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
//import org.eclipse.debug.internal.ui.DebugUIPlugin;
//import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.m2m.qvt.oml.debug.core.launch.QVTODebugConfiguration;
import org.eclipse.m2m.qvt.oml.debug.core.srclookup.QVTOSourceLookupDirector;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;
import org.eclipse.swt.widgets.Display;


/**
 * A JUnit test class for QVTO Debugger
 * @author sboyko
 */
public class DebuggerTransformation extends TestTransformation {

	private ILaunchConfigurationWorkingCopy myLaunchConfigurationWorkingCopy;


    public DebuggerTransformation(ModelTestData data) {
    	super(data);
	}
	
    public void setUp() throws Exception {
		super.setUp();

//		Display.getCurrent().syncExec(new Runnable() {
//			public void run() {
//				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE, MessageDialogWithToggle.NEVER);
//				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_ACTIVATE_DEBUG_VIEW, "false"); //$NON-NLS-1$
//				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_SWITCH_PERSPECTIVE_ON_SUSPEND, MessageDialogWithToggle.NEVER);
//			}
//		});

    }
    
    @Override
    protected void runTest() throws Throwable {
        checkTransformation(new TransformationChecker(new DebuggerTransformer()));
    }
	
    /**
     * Suspends current thread until the debugger listener resumes it
     * @param time - maximum time to wait in milliseconds, 0 for no time-bound
     * @throws InterruptedException
     */
    public void waitForDebugger(int time) throws InterruptedException {
    	synchronized(this) {
			if (time > 0) {
				this.wait(time);
			}
			else {
				this.wait();
			}
		};	    	
    }
    
    /**
     * Adds a breakpoint on the given line to the module currently selected in launch
     * configuration
     * @param line - line number to set a breakpoint on
     * @throws CoreException
     */
    public void addBreakpoint(int line) throws CoreException {
		IFile iFile = WorkspaceUtils.getWorkspaceFile(myLaunchConfigurationWorkingCopy.getAttribute(IQvtLaunchConstants.MODULE, "")); //$NON-NLS-1$
		URI sourceURI = URIUtils.getResourceURI(iFile);
		QVTOBreakpoint lb = new QVTOBreakpoint(sourceURI, line);
        DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lb);
    }

    /**
     * Launches the debugger with a configuration set up by {@link #setTestData(String)}
     * @throws CoreException
     * @throws InterruptedException 
     */
    public void runDebugger() throws CoreException, InterruptedException {
		ILaunchConfiguration config = myLaunchConfigurationWorkingCopy.doSave();
		
		QVTODebugConfiguration debugConfig = new QVTODebugConfiguration();
		ILaunch launch = new Launch(config, ILaunchManager.DEBUG_MODE, new QVTOSourceLookupDirector());
		
		debugConfig.launch(config, ILaunchManager.DEBUG_MODE, launch, new NullProgressMonitor());

        while(!launch.isTerminated()) {
        	while (Display.getDefault().readAndDispatch()) {
        	}
        	Thread.sleep(10);
        }
    }

    
	private class DebuggerTransformer implements ITransformer {
		
		public List<URI> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
	        ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
	        myLaunchConfigurationWorkingCopy = type.newInstance(null, "debugConfig"); //$NON-NLS-1$
	        
	        List<URI> resultUri = new ArrayList<URI>(2);
			
	        int index = 1;
	        for (URI uri : inUris) {
	    		IResource resource = URIUtils.getResource(uri);
	    		uri = URIUtils.getResourceURI(resource);
	        	QvtLaunchUtil.saveTargetUriData(myLaunchConfigurationWorkingCopy, new TargetUriData(TargetType.EXISTING_CONTAINER, uri.toString(), null, false), index);
	        	index++;
	        }
	        for (URI uri : getData().getExpected(getProject())) {
	    		IResource resource = URIUtils.getResource(uri);
	    		uri = URIUtils.getResourceURI(resource).appendFileExtension("ecore"); //$NON-NLS-1$
	        	resultUri.add(uri);
	        	QvtLaunchUtil.saveTargetUriData(myLaunchConfigurationWorkingCopy, new TargetUriData(TargetType.NEW_MODEL, uri.toString(), null, false), index);
	        	index++;
	        }

	    	myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.MODULE, URIUtils.getResourceURI(transformation).toString());
	        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.ELEM_COUNT, index-1);
	        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, qvtContext.getConfigProperties());
	        
	        runDebugger();
	        
	        return resultUri;
		}

	}

}
