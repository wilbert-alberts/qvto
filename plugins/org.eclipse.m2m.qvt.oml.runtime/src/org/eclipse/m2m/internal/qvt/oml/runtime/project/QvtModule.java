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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConfigProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.Property;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.EMFType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.osgi.util.NLS;

public abstract class QvtModule {
    private QvtCompilerOptions myQvtCompilerOptions;

    protected QvtModule() {		
    }

    public abstract CompiledModule getModule() throws MdaException;

    public abstract QvtCompiler getCompiler() throws MdaException;

    public String getModuleName() throws MdaException {
        return getModule().getModule().getName();
    }


    public EClass getIn() throws MdaException {
        EClass inCls = getInType(getModule());
        if (inCls != null) {
            return inCls;
        }
        for (ModelParameter modelParam : getModule().getModule().getModelParameter()) {
            if (modelParam.getKind() == DirectionKind.IN || modelParam.getKind() == DirectionKind.INOUT) {
                List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
                if (!metamodels.isEmpty()) {
                    return metamodels.get(0).eClass();
                }
                return null;
            }
        }	    
        return null;
    }


    public EClass getOut() throws MdaException {
        EClass outCls = getReturnType(getModule());
        if (outCls != null) {
            return outCls;
        }
        for (ModelParameter modelParam : getModule().getModule().getModelParameter()) {
            if (modelParam.getKind() == DirectionKind.OUT) {
                List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
                if (!metamodels.isEmpty()) {
                    return metamodels.get(0).eClass();
                }
                return null;
            }
        }	    
        return null;
    }

    public List<TransformationParameter> getParameters() throws MdaException {
        Module module = getModule().getModule();
        ImperativeOperation mainMethod = (ImperativeOperation) module.getEntry();

        List<TransformationParameter> transfParams = new ArrayList<TransformationParameter>(module.getModelParameter().size());
        for (ModelParameter modelParam : module.getModelParameter()) {
            MappingParameter refinedParam = findMainParameter(mainMethod, modelParam);
            transfParams.add(createTransfParam(modelParam, refinedParam));
        }

        if (transfParams.isEmpty() && mainMethod != null) {
            for (EParameter mainParam : mainMethod.getEParameters()) {
                transfParams.add(createTransfParam((MappingParameter) mainParam));
            }
            for (VarParameter mainParam : mainMethod.getResult()) {
                if (mainParam.getEType() instanceof VoidType) {
                    continue;
                }
                transfParams.add(createTransfParam((MappingParameter) mainParam));
            }
        }

        return transfParams;
    }
    
    public QvtCompilerOptions getQvtCompilerOptions() {
        return myQvtCompilerOptions;
    }

    public void setQvtCompilerOptions(QvtCompilerOptions options) {
        myQvtCompilerOptions = options;
    }

    private TransformationParameter createTransfParam(final MappingParameter mainParam) {
        return new TransformationParameter() {

            public DirectionKind getDirectionKind() {
                if (mainParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.IN) {
                    return DirectionKind.IN;
                }
                if (mainParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
                    return DirectionKind.OUT;
                }
                return DirectionKind.INOUT;
            }

            public String getEntryName() {
                return mainParam.getName() != null ? mainParam.getName() : ""; //$NON-NLS-1$
            }

            public EClassifier getEntryType() {
                return mainParam.getEType();
            }

            public List<EPackage> getMetamodels() {
                EObject rootContainer = EcoreUtil.getRootContainer(mainParam.getEType());
                if (rootContainer instanceof EPackage) {
                    return Collections.singletonList((EPackage) rootContainer);
                }
                return Collections.emptyList();
            }

            public String getModelTypeName() {
                if (getMetamodels().isEmpty()) {
                    return ""; //$NON-NLS-1$
                }
                return getMetamodels().get(0).getName();
            }

            public String getName() {
                return getEntryName();
            }

        };
    }

    private TransformationParameter createTransfParam(final ModelParameter modelParam, final MappingParameter refinedParam) {
        return new TransformationParameter() {

            public DirectionKind getDirectionKind() {
                if (modelParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.IN) {
                    return DirectionKind.IN;
                }
                if (modelParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
                    return DirectionKind.OUT;
                }
                return DirectionKind.INOUT;
            }

            public String getEntryName() {
                return refinedParam != null ? refinedParam.getName() : ""; //$NON-NLS-1$
            }

            public EClassifier getEntryType() {
                return refinedParam != null ? refinedParam.getEType() : null;
            }

            public List<EPackage> getMetamodels() {
                return ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
            }

            public String getModelTypeName() {
                if (modelParam.getEType() instanceof ModelType) {
                    return ((ModelType) modelParam.getEType()).getName();
                }
                return ""; //$NON-NLS-1$
            }

            public String getName() {
                return modelParam.getName();
            }

        };
    }

    private MappingParameter findMainParameter(ImperativeOperation mainMethod, ModelParameter modelParam) {
        if (mainMethod != null) {
            for (EParameter mainParam : mainMethod.getEParameters()) {
                if (((MappingParameter) mainParam).getExtent() == modelParam) {
                    return (MappingParameter) mainParam;
                }
            }
            for (VarParameter mainParam : mainMethod.getResult()) {
                if (((MappingParameter) mainParam).getExtent() == modelParam) {
                    return (MappingParameter) mainParam;
                }
            }
        }
        return null;
    }

    /**
     * Collects all the configuration properties used by this module
     * including the ones declared by imported modules
     * @return LinkedHashSet of properties
     * @throws MdaException as {@link #getModule()} does
     */
    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
        CompiledModule module = getModule();
        if (module == null) {
            return Collections.<QvtConfigurationProperty>emptySet();
        }
        Set<Module> moduleSet = new HashSet<Module>();

        collectImports(module, moduleSet);

        Set<QvtConfigurationProperty> propSet = new LinkedHashSet<QvtConfigurationProperty>();
        for (Module m : moduleSet) {
            collectProperties(m, propSet);
        }
        return propSet;
    }

    public static EClass getReturnType(CompiledModule module) {
        ImperativeOperation mainMethod = (ImperativeOperation) module.getModule().getEntry();
        if (mainMethod == null) {
            return null;
        }

        if (mainMethod.getResult().isEmpty()) {
            return null;
        }
        EClassifier type = mainMethod.getResult().get(0).getEType();
        if (false == type instanceof EClass) {
            return null;
        }
        return (EClass) type;
    }


    public static EClass getInType(CompiledModule module) {
        ImperativeOperation mainMethod = (ImperativeOperation) module.getModule().getEntry();
        if (mainMethod == null) {
            return null;
        }

        List<EParameter> params = mainMethod.getEParameters();
        if (params.isEmpty()) {
            return null;
        }
        EClassifier type = params.get(0).getEType();
        if (false == type instanceof EClass) {
            return null;
        }
        return (EClass) type;
    }

    /**
     * @return A string representation uniquely identifying the given QVT module.
     */
    @Override
    public abstract String toString();


    protected void checkModuleErrors(CompiledModule mappingModule) throws MdaException {
        List<QvtMessage> errors = new ArrayList<QvtMessage>();
        TransformationUtil.getErrors(mappingModule, errors);
        if(!errors.isEmpty()) {
            throw new MdaException(NLS.bind(Messages.TransformationUtil_ParseTransformationError, toString(), errors.size()));
        }		
    }	

    /**
     * Collects all the imported modules (including ones imported implicitly), non-recursive,
     * cyclic-import compatible
     * @param module - root module
     * @param moduleSet - resulting set
     */
    private void collectImports(CompiledModule module, Set<Module> moduleSet) {
        // WFS on imports graph
        Queue<Module> queue = new LinkedList<Module>();
        queue.offer(module.getModule());
        while (!queue.isEmpty()) {
            Module m = queue.poll();
            moduleSet.add(m);
            for (ModuleImport imp : m.getModuleImport()) {
                Module element = imp.getImportedModule();
                if (!moduleSet.contains(element)) {
                    moduleSet.add(element);
                    queue.offer(element);                    
                }
            }
        }
    }


    /**
     * Collects configuration properties declared by a mapping module
     * @param module - a mapping module
     * @param propSet - a set to put properties to
     */
    private void collectProperties(Module module, Set<QvtConfigurationProperty> propSet) {
        for (Property element : module.getConfigProperty()) {
            if (element instanceof ConfigProperty) {
                ConfigProperty property = (ConfigProperty) element;
                EClassifier type = property.getEType();
                if (type instanceof EDataType) {
                    propSet.add(
                            new QvtConfigurationProperty(
                                    property.getName(), 
                                    new EMFType((EDataType) type)
                            )
                    );
                } else if (QvtOperationalUtil.isPrimitiveType(type)) {
                    propSet.add(
                            new QvtConfigurationProperty(
                                    property.getName(), 
                                    new QvtPrimitiveType(type)
                            )
                    );
                }
            }
        }
    }
}