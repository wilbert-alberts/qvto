package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.common.io.IOFile;

public class TestFailedTransformation extends TestTransformation {

    public TestFailedTransformation(ModelTestData data) {
        super(data);
        setName("interpret_" + data.getName()); //$NON-NLS-1$
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
			context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, new PrintWriter(myLogger));
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), context);
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
