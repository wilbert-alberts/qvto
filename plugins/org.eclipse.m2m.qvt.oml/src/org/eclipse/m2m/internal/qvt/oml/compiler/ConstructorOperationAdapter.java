package org.eclipse.m2m.internal.qvt.oml.compiler;

import org.eclipse.m2m.internal.qvt.oml.cst.adapters.AbstractGenericAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Constructor;

public class ConstructorOperationAdapter extends AbstractGenericAdapter<ConstructorOperationAdapter> {

	public ConstructorOperationAdapter(Constructor referredConstructor) {
		myReferredConstructor = referredConstructor;
	}
	
	public Constructor getReferredConstructor() {
		return myReferredConstructor;
	}
	
	public boolean isAdapterForType(Object type) {	
		return ConstructorOperationAdapter.class == type;
	}

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ConstructorOperationAdapter;
    }

    @Override
    public int hashCode() {
        return ConstructorOperationAdapter.class.hashCode();
    }
    
    private final Constructor myReferredConstructor;

}
