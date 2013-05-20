/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ocl.transformations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractBlackboxProvider;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxException;
import org.eclipse.m2m.internal.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.internal.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.m2m.internal.qvt.oml.ocl.OclQvtoPlugin;

public class LegacyNativeLibraryProviderAdapter extends AbstractBlackboxProvider {
	
	public LegacyNativeLibraryProviderAdapter() {
		super();
	}

	@Override
	protected String getProviderID() {
		return "legacy"; //$NON-NLS-1$
	}	
	
	@Override
	public List<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext loadContext) {
		LibrariesRegistry registry = OclQvtoPlugin.getDefault().getLibrariesRegistry();
		
		final Collection<Library> rawLibs = registry.getLibraries();
		List<AbstractCompilationUnitDescriptor> libDescriptors = new ArrayList<AbstractCompilationUnitDescriptor>(rawLibs.size());
		for (final Library lib : rawLibs) {
			libDescriptors.add(new LibraryDescriptor(lib));			
		}
		return libDescriptors;
	}
	
	@Override
	public AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext) {
		LibrariesRegistry registry = OclQvtoPlugin.getDefault().getLibrariesRegistry();
		Library library = registry.getLibrary(qualifiedName);
		if(library != null) {
			return new LibraryDescriptor(library);
		}
		
		return null;		
	}
	
	@Override
	public CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException {
		if(descriptor instanceof LibraryDescriptor == false) {
			throw new IllegalArgumentException("Descriptor not recognized by provider"); //$NON-NLS-1$
		}
		
		try {
			LibraryDescriptor libraryDescriptor = (LibraryDescriptor) descriptor;
			return createCompilationUnit(LegacyNativeLibSupport.INSTANCE.defineLibrary(libraryDescriptor.fLibrary));			
		} catch (LibraryCreationException e) {
			new BlackboxException(e.getMessage(), e);			
		}
		
		return null;
	}		

	
	private class LibraryDescriptor extends AbstractCompilationUnitDescriptor {

		private Library fLibrary;
		
		protected LibraryDescriptor(Library library) {
			super(LegacyNativeLibraryProviderAdapter.this, library.getId());
			fLibrary = library;
		}
				
		@Override
		public String getDescription() {
			return fLibrary.getLibraryClassName();
		}
		
	}	
}
