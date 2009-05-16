@echo off

set LPG_HOME=.\..\.externalTool\lpgdistrib

set LPG_INCLUDE=%LPG_HOME%\include;.;
set LPG_TEMPLATE=%LPG_HOME%\templates;

%LPG_HOME%\lpgexe\lpg.exe -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.parser QvtOpLPGParser.g

FOR %%F IN (*sym.java,*prs.java) DO  %LPG_HOME%\..\perl\perl.exe patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (*.java_nls) DO  move /Y %%F %%~nF.java

move /Y *.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\parser

