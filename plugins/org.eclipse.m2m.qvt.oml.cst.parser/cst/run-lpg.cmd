@echo off

set LPG_HOME=.\..\.externalTool\lpgdistrib

set LPG_INCLUDE=%LPG_HOME%\include;.;
set LPG_TEMPLATE=%LPG_HOME%\templates;


rem --- QVTO Parser ---

%LPG_HOME%\lpgexe\lpg.exe -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.parser QVTOParser.g

FOR %%F IN (*sym.java,*prs.java) DO  %LPG_HOME%\..\perl\perl.exe patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (*.java_nls) DO  move /Y %%F %%~nF.java

move /Y *.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\parser


rem --- QVTO Completion Parser ---

%LPG_HOME%\lpgexe\lpg.exe -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.completion.parser completion/LightweightParser.lpg
%LPG_HOME%\lpgexe\lpg.exe -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.completion.parser completion/LightweightTypeParser.lpg

FOR %%F IN (*sym.java,*prs.java) DO  %LPG_HOME%\..\perl\perl.exe patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (*.java_nls) DO  move /Y %%F %%~nF.java

move /Y *.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\completion\parser
