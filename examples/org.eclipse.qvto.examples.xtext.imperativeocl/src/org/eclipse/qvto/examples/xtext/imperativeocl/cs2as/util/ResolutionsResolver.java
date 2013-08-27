package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class ResolutionsResolver {
	
	
	/**
	 * Basic algorithm to resolve {@link IFutureResolution}s.
	 *  
	 * @param resolutions a list of future resolutions to resolve.
	 * @return a list of pending
	 * resolutions, which may be empty if every future resolution was successfully resolved.  
	 */
	@NonNull
	public static List<IFutureResolution> resolve(@Nullable List<IFutureResolution> resolutions) {

		List<IFutureResolution> pendingResolutions = new ArrayList<IFutureResolution>();
		boolean needToResolve = resolutions != null && resolutions.size() > 0;
		while (needToResolve) {
			pendingResolutions.clear();
			needToResolve = false;
			for (IFutureResolution resolution : resolutions) {
				if (!resolution.isResolved()) {
					if (resolution.resolve()) {
						needToResolve = true; // a resolution was solved so we need to process pending resolutions again
					} else {
						pendingResolutions.add(resolution);
					}
				}
			}
			resolutions = pendingResolutions;
		}
		return pendingResolutions;
	}
}