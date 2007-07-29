package org.eclipse.m2m.qvt.oml.internal.cst.adapters;

import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;

/**
 * @author aigdalov
 */

public class QvtOpLexerAdapter extends AbstractGenericAdapter<QvtOpLexer>{
    public boolean isAdapterForType(Object type) {
        return type == QvtOpLexer.class;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof QvtOpLexer;
    }

    @Override
    public int hashCode() {
        return QvtOpLexer.class.hashCode();
    }
}