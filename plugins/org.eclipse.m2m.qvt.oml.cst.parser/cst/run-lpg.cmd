@echo off

set LPG_HOME=.\..\.externalTool\lpgdistribution

set LPG_INCLUDE=%LPG_HOME%\include;.;
set LPG_TEMPLATE=%LPG_HOME%\templates;

%LPG_HOME%\lpgexe\lpg.exe -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.parser QvtOpLPGParser.g

move /Y *.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\parser

