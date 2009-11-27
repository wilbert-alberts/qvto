package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;

public interface DebuggableExecutorAdapter {
	
	void connect(IQVTODebuggerShell debugShell);
	
	Diagnostic execute() throws IllegalStateException;
	
	CompiledUnit getUnit();	
}