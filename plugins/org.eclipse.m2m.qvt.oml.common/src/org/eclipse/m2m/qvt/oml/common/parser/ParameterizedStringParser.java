/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.common.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.osgi.util.NLS;



/** @author pkobiakov */
public class ParameterizedStringParser {
	public ParameterizedStringParser(String data) {
		myData = data;
		myIdx = 0;
	}
    
    public static class ParseException extends Exception {
		private static final long serialVersionUID = 999576347266227039L;

		public ParseException(String s) { super(s); }
    }
    
    public Node[] parse() throws ParseException {
		StringBuffer s = new StringBuffer();
        boolean inVar = false;
        
        List<Node> nodes = new ArrayList<Node>();
        LOOP: for(;;) {
            int ch = eatChar();
            switch(ch) {
                case -1: {
                    if(s.length() > 0) {
                        if(inVar) {
                            throw new ParseException(NLS.bind(Messages.ParameterizedStringParser_UnterminatedVariable, myData));
                        }
                        else {
                            nodes.add(makeNode(s.toString(), false));
                            s.delete(0, s.length());
                        }
                    }
                   break LOOP;
                }
                
                case DOLLAR: {
                    if(getChar() != LEFT_CURL) {
                        s.append((char)ch);
                    }
                    else {
                        eatChar();

                        if(s.length() > 0) {
                            nodes.add(makeNode(s.toString(), inVar));
                            s.delete(0, s.length());
                        }
                        inVar = true;
                    }
                    break;
                }
                
                case RIGHT_CURL: {
                    if(inVar == false) {
                        s.append((char)ch);
                    }
                    else {
                        nodes.add(makeNode(s.toString(), inVar));
                        s.delete(0, s.length());
                        inVar = false;
                    }
                    break;
                }
                
                default: {
                    s.append((char)ch);
                    break;
                }
            }
		}
		
		return (Node[])nodes.toArray(new Node[nodes.size()]);
	}
    
    public static String[] getVarNames(Node[] nodes) {
        List<String> varNames = new ArrayList<String>();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            if(node instanceof VarNode) {
                VarNode varNode = (VarNode)node;
                varNames.add(varNode.getVarName());
            }
        }
        
        return varNames.toArray(new String[varNames.size()]);
    }
    
    public static String toString(Node[] nodes) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            s.append(node.toString());
        }
        
        return s.toString();
    }
    
    public static String resolve(Node[] nodes, Map params) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            if(node instanceof VarNode) {
                VarNode varNode = (VarNode)node;
                String value = (String)params.get(varNode.getVarName());
                s.append(value != null ? value : varNode.toString());
            }
            else {
                s.append(node.toString());
            }
        }
        
        return s.toString();
    }
	
    private Node makeNode(String s, boolean inVar) {
        Node node;
        if(inVar) {
            node = new VarNode(s);
        }
        else {
            node = new TextNode(s);
        }
        
        return node;
    }

    private int eatChar() {
		if(myIdx >= myData.length()) {
			return -1;
		}
		
		char c = myData.charAt(myIdx++); 
		return c;
	}
	
	private int getChar() {
		int oldIdx = myIdx;
		try {
			return eatChar();
		}
		finally {
			myIdx = oldIdx;
		}
	}
	
	private final String myData;
    private int myIdx;
	
	public static final char DOLLAR = '$';
    public static final char LEFT_CURL = '{';
    public static final char RIGHT_CURL = '}';
}
