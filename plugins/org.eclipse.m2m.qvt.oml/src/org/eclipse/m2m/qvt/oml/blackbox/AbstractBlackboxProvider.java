/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.blackbox;

import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;


public abstract class AbstractBlackboxProvider {
 
	public interface CompilationUnit {
		List<QvtOperationalModuleEnv> getElements();
	}

	
	protected AbstractBlackboxProvider() {
		super();
	}
	
	protected CompilationUnit createCompilationUnit(QvtOperationalModuleEnv moduleEnv) {
		return createCompilationUnit(Collections.singletonList(moduleEnv));
	}

	protected CompilationUnit createCompilationUnit(final List<QvtOperationalModuleEnv> moduleEnv) {
		return new CompilationUnit() {
			public List<QvtOperationalModuleEnv> getElements() {
				return Collections.unmodifiableList(moduleEnv);
			}
		};
	}
	
	public abstract List<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext resolutionContext);
	
	public abstract AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext);

	public abstract CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException;
}
