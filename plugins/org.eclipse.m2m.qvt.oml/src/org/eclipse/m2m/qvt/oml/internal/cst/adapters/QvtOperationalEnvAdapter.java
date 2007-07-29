package org.eclipse.m2m.qvt.oml.internal.cst.adapters;

import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;

/**
 * @author aigdalov
 */

public class QvtOperationalEnvAdapter extends AbstractGenericAdapter<QvtOperationalEnv> {
    public boolean isAdapterForType(Object type) {
        return type == QvtOperationalEnv.class;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof QvtOperationalEnvAdapter;
    }

    @Override
    public int hashCode() {
        return QvtOperationalEnvAdapter.class.hashCode();
    }
}