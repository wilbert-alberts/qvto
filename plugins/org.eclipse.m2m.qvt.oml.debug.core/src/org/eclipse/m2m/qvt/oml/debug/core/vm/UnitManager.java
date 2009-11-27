package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.util.LineNumberProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;

public class UnitManager {

	private final CompiledUnit fMainUnit;
	private Map<URI, UnitEntry> fUri2UnitMap;
	
	UnitManager(CompiledUnit mainUnit) {
		if(mainUnit == null) {
			throw new IllegalArgumentException("null main unit"); //$NON-NLS-1$
		}
		
		fMainUnit = mainUnit;
		try {
			fUri2UnitMap = createFile2UnitMap(mainUnit);
		} catch (IOException e) {
			fUri2UnitMap = Collections.emptyMap();			
			QVTODebugCore.log(e);
		}
	}	
	
	public CompiledUnit getCompiledModule(URI unitURI) {
		UnitEntry numberProvider = fUri2UnitMap.get(unitURI);
		if(numberProvider != null) {
			return numberProvider.getCompiledModule();
		}
		
		return null;
	}
	
	public LineNumberProvider getLineNumberProvider(URI unitURI) {
		return fUri2UnitMap.get(unitURI);
	}
	
    public CompiledUnit findUnitForModule(Module module) {
    	return findCompiledModuleRec(fMainUnit, module);
    }

    private CompiledUnit findCompiledModuleRec(CompiledUnit rootModule, Module module) {
    	if (rootModule.getModules().contains(module)) {
    		return rootModule;
    	}
    	
    	for (CompiledUnit impModule : rootModule.getCompiledImports()) {
    		CompiledUnit findModule = findCompiledModuleRec(impModule, module);
    		if (findModule != null) {
    			return findModule;
    		}
    	}
    	return null;
    }	
	
	private Map<URI, UnitEntry> createFile2UnitMap(CompiledUnit unit) throws IOException {
		HashSet<CompiledUnit> allUnits = new HashSet<CompiledUnit>();
		allUnits.add(unit);
		QvtOperationalParserUtil.collectAllImports(unit, allUnits);
		Map<URI, UnitEntry> file2Unit = new HashMap<URI, UnitEntry>();
		
		for (CompiledUnit nextUnit : allUnits) {
			// FIXME
			IModuleSourceInfo sourceBinding = ASTBindingHelper.getModuleSourceBinding(unit.getModules().get(0));
			if(sourceBinding != null) {
				file2Unit.put(unit.getURI(), new UnitEntry(unit, sourceBinding.getLineNumberProvider()));
			}
		}
		
		return file2Unit;
	}
	    
    private static class UnitEntry implements LineNumberProvider {
    	
        private final CompiledUnit fModule;  
        private LineNumberProvider fProvider;    	

        public UnitEntry(CompiledUnit unit, LineNumberProvider lineNumberProvider) {
            fModule = unit;
    		fProvider = lineNumberProvider;
        }
        
        public CompiledUnit getCompiledModule() {
            return fModule;
        }
        
        public int getLineEnd(int lineNumber) {
            return fProvider.getLineEnd(lineNumber);
        }

        public int getLineCount() {
            return fProvider.getLineCount();
        }

        public int getLineNumber(int offset) {
            return fProvider.getLineNumber(offset);
        } 
    }    
}
