package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.util;

import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;


/**
 * @author asbh
 *
 */

// FIXME implements Continuation to comply with current APIs. This continuations should be removed in the future
public interface IFutureResolution extends Continuation<Boolean>{
	
	/**
	 * @return <code>true</code> if the future resolution is currently resolved
	 */
	boolean isResolved();
	
	/**
	 * The future resolution tries to be resolved
	 * 
	 * @return <code>true</code> if the future resolution could be resolved now. 
	 */
	boolean resolve(); // TODO This will require some parameters, probably the environment. Maybe, some context by construction.

}
