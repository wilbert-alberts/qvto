package org.eclipse.m2m.tests.qvt.oml;

import java.io.StringReader;

import junit.framework.TestCase;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.ocl.ParserException;

public class TestParsingMACLineBreaks extends TestCase {

	public TestParsingMACLineBreaks(String name) {
		super(name);
	}

	public void testBreakLastChar() throws Exception {
		String contents = "abc;\r";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}
	
	public void testBreakWinLastBreak() throws Exception {
		String contents = "abc;\r\n";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}
	
	public void testBreakUnixLastBreak() throws Exception {
		String contents = "abc;\n";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}
	
	public void testMixed() throws Exception {
		String contents = "a\n \r \r\n";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 3);
	}
	
	public void testBreakFirstChar() throws Exception {
		String contents = "\rabc;";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}
	
	public void testBreakWinFirstBreak() throws Exception {
		String contents = "\r\nabc;";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}
	
	public void testBreakUnixFirstBreak() throws Exception {
		String contents = "\nabc;";
		QvtOpLexer lexer = createLexer(contents);
		
		final int lineCount = lexer.getLineCount();
		assertEquals(lineCount, 1);
	}

	
	private QvtOpLexer createLexer(String contents) throws ParserException {
		final QvtOpLexer lexer = QvtOperationalParser.createLexer(
				new StringReader(contents), "testLineBreak", 
				QvtOperationalEnvFactory.INSTANCE.createEnvironment());
		
		lexer.computeLineOffsets();
		
		return lexer;
	}
}
