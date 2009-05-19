package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.m2m.internal.qvt.oml.common.io.IOFile;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

public class TestFailedTransformation extends TestTransformation {

    public TestFailedTransformation(ModelTestData data) {
        super(data);
        setName(TestQvtInterpreter.PREFIX + data.getName()); //$NON-NLS-1$
    }
	
	public TestFailedTransformation(String testName) {
		this(new FileToFileData(TestDataMapper.getActualTestName(TestQvtInterpreter.PREFIX, testName)));
	}    
    
    @Override
	public void runTest() throws Exception {
		runTransformation();
		assertLogMatch("qvtTraceLog.stack"); //$NON-NLS-1$
	}
	
	private QvtRuntimeException runTransformation() throws Exception {
        ITransformer transformer = TestQvtInterpreter.TRANSFORMER;
		try {
			IContext context = getData().getContext();
			Context newContext = QvtLaunchUtil.createContext(context.getConfigProperties());
			newContext.setLog(new WriterLog(myLogger));
			newContext.getSessionData().setValue(QVTEvaluationOptions.FLAG_READONLY_GUARD_ENABLED, Boolean.TRUE);
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), newContext);
		} catch (QvtRuntimeException e) {
			return e;			
		}
		
		return null;
	}

	private void assertLogMatch(String testCase) throws Exception {
		String expectedContents = loadExpectedTraceLog(testCase);
		assertFalse("Non-empty trace expected", expectedContents.length() == 0); //$NON-NLS-1$
		
		String logContents = myLogger.getBuffer().toString();
		assertFalse("Non-empty trace expected", logContents.length() == 0); //$NON-NLS-1$
		
		assertEquals(expectedContents, logContents);
	}
	
	private String loadExpectedTraceLog(String fileName) throws IOException {
		File parentFolder = getData().getTransformation(getTestProject().getProject()).getParentFile();
		return MiscUtil.readStream(new IOFile(new File(parentFolder, fileName)));
	}
	
	private final StringWriter myLogger = new StringWriter();
}
