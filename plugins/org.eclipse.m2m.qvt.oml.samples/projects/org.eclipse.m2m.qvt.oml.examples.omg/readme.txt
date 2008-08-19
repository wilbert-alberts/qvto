Deviations from OMG specification
---------------------------------

- Strings literals "" not supported, only OCL style '' is allowed 

- self.attribute->object(a) Column {…}" as a shorthand for "self. attribute->xcollect(a| object Column {…})
  is not supported

- when guard in mapping operations should be a list of expressions (not a single one) 
    when {self.kind = 'persistent' /*;*/}

- inlined meta-model definition not supported, ecore files with corresponding models provided

- no implicit meta-model resolution by name

- intermediate classes not supported, workaround by using Tuples for temporary 
  structural data  

- aliases for isKindOf(...) and other oclXXX related operation are not supported, 
  only OCL oclIsKindOf(...), etc. is allowed

- the 'Encapsulation' example has been adjusted to uml2 meta-model from the Eclipse MDT project

- merge, inherits do not support referencing of mapping operations by local name, 
  only qualified names are supported

- composite assignments are not supported -> split to multiple assignments
	constraint := {
		self.constraint[isStereotypedBy("precondition")]->map createPrecondition();
		self.constraint[isStereotypedBy("goal")]->map createGoal();
	};

- resolve calls on collections using '->' are not supported, 
   supplier->resolveone(WorkDefinition) =>  supplier.resolveone(WorkDefinition)

- assignments of collection to properties of * multiplicity are complemented by corresponding 
  asSet(), asOrderedSet() casting calls to avoid compilation errors while OMG spec allows this
  