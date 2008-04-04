package org.eclipse.m2m.internal.qvt.oml.cst.adapters;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

/**
 * @author aigdalov
 */

public abstract class AbstractGenericAdapter<T> implements Adapter {
    private Notifier myTarget;
    private T myObject;
    
    public Notifier getTarget() {
        return myTarget;
    }

    public void notifyChanged(Notification notification) {
    }

    public void setTarget(Notifier newTarget) {
        myTarget = newTarget;
    }

    public T getObject() {
        return myObject;
    }

    public void setObject(T object) {
        myObject = object;
    }
}