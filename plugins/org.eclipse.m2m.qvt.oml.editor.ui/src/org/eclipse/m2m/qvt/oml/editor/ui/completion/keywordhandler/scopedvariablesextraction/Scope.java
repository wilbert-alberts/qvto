/**
 * 
 */
package org.eclipse.m2m.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction;

import java.util.ArrayList;
import java.util.List;

/**
* @author aigdalov
* Created on Nov 21, 2007
*/
class Scope {
    private Scope myParent;
    private List<String> myVariables;
    
    public Scope(Scope parent) {
        myParent = parent;
    }
    
    public Scope getParent() {
        return myParent;
    }
    
    public void addVariable(String varDecl) {
        if (myVariables == null) {
            myVariables = new ArrayList<String>();
        }
        myVariables.add(varDecl);
    }
    
    private void serialize(StringBuilder stringBuilder) {
        if (myParent != null) {
            myParent.serialize(stringBuilder);
        }
        if (myVariables != null) {
            for (String varDecl : myVariables) {
                stringBuilder.append(varDecl);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(stringBuilder);
        return stringBuilder.toString();
    }
}