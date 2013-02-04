/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;


public class ModelExtentHelper {

	private static class ExtentEntry {

		final ModelExtent extent;
		final URI saveAsURI;

		ExtentEntry(ModelExtent extent, URI saveAsURI) {
			assert extent != null;
			this.extent = extent;
			this.saveAsURI = saveAsURI;
		}
	}
	
	
	private final OperationalTransformation fTransformation;
	private final List<URI> fModelExtentURIs;
	private final LinkedHashMap<ModelParameter, ExtentEntry> fExtentMap;
	private final ResourceSet fResourceSet;
	
	
	public ModelExtentHelper(OperationalTransformation transformation, List<URI> modelExtentURIs, ResourceSet resSet) {
		if(transformation == null || modelExtentURIs == null || modelExtentURIs.contains(null)) {
			throw new IllegalArgumentException();
		}

		fTransformation = transformation;
		fModelExtentURIs = modelExtentURIs;
		fExtentMap = new LinkedHashMap<ModelParameter, ExtentEntry>();
		fResourceSet = resSet;
	}
	
	public ModelExtentHelper(OperationalTransformation transformation, List<URI> modelExtentURIs) {
		this(transformation, modelExtentURIs, new ResourceSetImpl());
	}
		
	public ResourceSet getResourceSet() {
		return fResourceSet;
	};

	public Diagnostic saveExtents() {
		BasicDiagnostic diagnostic = QvtPlugin.createDiagnostic("Save model param extents diagnostic");

		for (ExtentEntry nextEntry : fExtentMap.values()) {
			URI saveAsURI = nextEntry.saveAsURI;
			if(saveAsURI != null) {
				Resource res = fResourceSet.getResource(saveAsURI, false);
				if(res == null) {
					res = fResourceSet.createResource(saveAsURI);
// add support for saving plain XML					
//					XMLResource r = new XMLResourceImpl(saveAsURI);
//					res = r;
//					r.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
//					r.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
//					r.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
//					r.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
				}

				if(res == null) {
					diagnostic.add(QvtPlugin.createWarnDiagnostic("No resistered factory for resource uri=" + saveAsURI));
					
					res = new XMIResourceImpl(saveAsURI);
					fResourceSet.getResources().add(res);
				}

				Diagnostic saveResDiagnostic = saveContents(res, nextEntry.extent.getContents());
				if(saveResDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(saveResDiagnostic);
				}
			}
		}

		return diagnostic;
	}

	private Diagnostic saveContents(Resource res, List<EObject> contents) {
        Map<String, Object> options = new HashMap<String, Object>(2);        
        options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
        options.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);               
        
        for (EObject eObject : contents) {
	        if(isDynamic(eObject)) {
	        	options.put("SCHEMA_LOCATION", Boolean.TRUE); //$NON-NLS-1$
	        	break;
	        }
        }
        
        try {
        	res.getContents().addAll(contents);
        	res.save(options);
        } catch (IOException e) {
			return QvtPlugin.createErrorDiagnostic(
					"Failed to save model extent uri=" + res.getURI(), e);
        }
		
		return Diagnostic.OK_INSTANCE;
	}
	
	public List<ModelExtent> loadExtents() throws DiagnosticException {
		fResourceSet.getResources().clear();
		
		List<ModelParameter> params = fTransformation.getModelParameter();
		if(params.size() != fModelExtentURIs.size()) {
			throw new DiagnosticException(QvtPlugin.createErrorDiagnostic(NLS.bind(
					Messages.InvalidModelParameterCountError, fModelExtentURIs
							.size(), params.size()), null));
		}

		int i = 0;
		for (URI uri : fModelExtentURIs) {
			ModelParameter nextParam = params.get(i++);
			DirectionKind kind = nextParam.getKind();
			URI saveAsURI = (kind != DirectionKind.IN) ? uri : null;
			URI loadURI = (kind != DirectionKind.OUT) ? uri : null; 
			
			ModelExtent extent;
			if(loadURI != null) {
				extent = loadExtent(nextParam, loadURI, fResourceSet);
			} else {
				extent = new BasicModelExtent();
			}

			ExtentEntry entry = new ExtentEntry(extent, saveAsURI);	
			fExtentMap.put(nextParam, entry);
		}
		
		return getExtents();
	}		
	
	private ModelExtent loadExtent(ModelParameter modelParameter, URI uri, ResourceSet rs) throws DiagnosticException {				
		Throwable error;
		try {
			Resource res = rs.getResource(uri, true);
			EList<EObject> contents = res.getContents();
			
			if(!res.getErrors().isEmpty()) {
				for (Resource.Diagnostic d : res.getErrors()) {
					// just take the first to manifest something is wrong
					throw new DiagnosticException(QvtPlugin.createErrorDiagnostic(
							d.getMessage(), null));
				}
			}
			
			return new BasicModelExtent(contents);
			
		} catch (WrappedException e) {
			error = (e.getCause() != null) ? e.getCause() : e;
		} catch (RuntimeException e) {
			error = e;
		}
		
		throw new DiagnosticException(QvtPlugin.createErrorDiagnostic("Failed to load model extent uri=" + uri, error));
	}
	
	private List<ModelExtent> getExtents() {
		List<ModelExtent> result = new ArrayList<ModelExtent>(fExtentMap.size());
		for (ExtentEntry extentEntry : fExtentMap.values()) {
			result.add(extentEntry.extent);
		}
		return result;
	}
		
	private static boolean isDynamic(EObject eObject) {
		// TODO
		return eObject instanceof EStructuralFeature.Internal.DynamicValueHolder;
	}	
}
