package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMConnectRequest;

public interface ConnectionRequestFactory {
	VMConnectRequest createConnectionRequest();
}