/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: src-gen/org/eclipse/qvto/examples/xtext/qvtoperational/QVTOperational.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface DecorableQVTOperationalCSVisitor<R>
		extends
		QVTOperationalCSVisitor<R>,
		org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.DecorableImperativeOCLCSVisitor<R> {

	void setUndecoratedVisitor(@NonNull
	org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R> visitor);
}
