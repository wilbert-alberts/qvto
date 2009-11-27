/**
 * 
 */
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.common.util.LineNumberProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.ASTNode;

class IterateBreakpointHelper {

	private final Set<VMBreakpoint> fBreakpoints;
	private final VMBreakpointManager fBPM;

	IterateBreakpointHelper(VMBreakpointManager breakpointManager) {
		fBPM = breakpointManager;
		fBreakpoints = new HashSet<VMBreakpoint>();
	}
	
	VMBreakpoint stepIterateElement(LoopExp element, UnitLocation currentLocation) {			
		Module currentModule = currentLocation.getModule();

		CompiledUnit compiledModule = fBPM.getUnitManager().getCompiledModule(currentLocation.getURI());
		
		
		LineNumberProvider lineNumProvider = fBPM.getLineNumberProvider(currentModule);
		if(lineNumProvider == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		OCLExpression<EClassifier> body = element.getBody();
		if (body == null) {
			return null;
		}

		int bodyLine = lineNumProvider.getLineNumber(body.getStartPosition());
		int elementLine = lineNumProvider.getLineNumber(element.getStartPosition());

		ASTNode iterateBreakpointedElement = body;

		// ensure we can suspend after stepping within iterator if it's body
		// is spread across multiple lines
		if (body instanceof BlockExp) {
			BlockExp blockExp = (BlockExp) body;
			int bodyEndLine = lineNumProvider.getLineNumber(blockExp.getEndPosition());
			if ((bodyEndLine == elementLine) || blockExp.getBody().isEmpty()) {
				return null;
			}
			
			iterateBreakpointedElement = blockExp.getBody().get(0);
		} else if (bodyLine == elementLine) {
			return null;
		}


		URI unitURI = currentLocation.getURI();
		VMBreakpoint breakpoint = createIterateBreakpoint(unitURI,
				iterateBreakpointedElement, elementLine);

		return breakpoint;
	}		

	boolean isIterateBreakpoint(VMBreakpoint breakpoint) {
		return fBreakpoints.contains(breakpoint);
	}

	VMBreakpoint createIterateBreakpoint(URI unitURI, ASTNode breakpointedElement, int line) {
		VMBreakpoint breakpoint = null;
		try {
			breakpoint = fBPM.createVMPrivateBreakpoint(unitURI, breakpointedElement, line, false);
			fBreakpoints.add(breakpoint);
		} catch (CoreException e) {
			QVTODebugCore.log(e.getStatus());
		}
		return breakpoint;
	}

	void removeIterateBreakpoint(VMBreakpoint breakpoint) {
		fBPM.removeBreakpoint(breakpoint);
		fBreakpoints.remove(breakpoint);
	}

	void removeAllIterateBreakpoints() {
		for (VMBreakpoint brk : fBreakpoints) {
			fBPM.removeBreakpoint(brk);
		}
		
		fBreakpoints.clear();
	}
}