package org.eclipse.qvto.examples.pivot.qvtoperational.utilities;
/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */


import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;
import org.eclipse.ocl.examples.pivot.utilities.AS2Moniker;
import org.eclipse.ocl.examples.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;

/**
 * QVTOperationalASResourceFactory supports creation of a QVTOperational AS resource and associated artefacts.
 */
public class QVTOperationalASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull String FILE_EXTENSION = "qvtoas";
	public static final @NonNull QVTOperationalASResourceFactory INSTANCE = new QVTOperationalASResourceFactory();

	private static final @NonNull ContentHandler CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		QVTOperationalPackage.eCONTENT_TYPE, new String[]{FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, QVTOperationalPackage.eNS_URI, null);
	
	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CONTENT_HANDLER);
	}
	
	/**
	 * Creates an instance of the resource factory.
	 */
	public QVTOperationalASResourceFactory() {
		super(QVTOperationalPackage.eCONTENT_TYPE, FILE_EXTENSION);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new QVTOperationalAS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new QVTOperationalAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new QVTOperationalASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new QVTOperationalASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new QVTOperationalPrettyPrintVisitor(printer);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new QVTOperationalToStringVisitor(s);
	}
}
