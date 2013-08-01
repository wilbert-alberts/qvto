package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;


/**
 * Context for the visits methods generator for the Containment visitor 
 * 
 * @author adolfosbh
 *
 */
public class ContainmentVisitsGeneratorCtx implements IContainmentVisitsGeneratorCtx {

	private GenModel sourceGenModel;
	
	private GenModel targetGenModel;
	
	public ContainmentVisitsGeneratorCtx(GenModel sourceGenModel, GenModel targetGenModel) {
		this.sourceGenModel = sourceGenModel;
		this.targetGenModel = targetGenModel;
	}
	
	public GenModel getSourceGenModel() {
		return sourceGenModel;
	}
	
	public GenModel getTargetGenModel() {
		return targetGenModel;
	}
}
