package org.eclipse.m2m.qvt.oml.debug.core.app;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTOVirtualMachineShell;

interface VMProvider {
	IQVTOVirtualMachineShell getVM() throws CoreException;
}