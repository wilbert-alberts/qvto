@echo off

rem Run me using '/org.eclipse.m2m.qvt.oml.editor.ui/CompletionParser.launch' 

set LPG_HOME=C:\GMF_Kafka\CVS-Eclipse\org.eclipse.m2m\org.eclipse.m2m.qvt.oml\plugins\org.eclipse.m2m.qvt.oml.cst.parser\.externalTool\lpgdistrib
set WS_LOC=C:\GMF_Kafka\CVS-Eclipse\org.eclipse.m2m\org.eclipse.m2m.qvt.oml\plugins


if not defined LPG_HOME goto no_home_var
if not exist %LPG_HOME% goto home_dir_notFound

set QVT_GRAMMAR=%WS_LOC%\org.eclipse.m2m.qvt.oml.cst.parser\cst
set LPG_QVT_GRAMMAR=%WS_LOC%\org.eclipse.m2m.qvt.oml.cst.parser\lpg
set LPG_INCLUDE=%LPG_HOME%\include;.;%QVT_GRAMMAR%;%LPG_QVT_GRAMMAR%

%LPG_HOME%\lpgexe\lpg.exe -backtrack -list LightweightParser.lpg
%LPG_HOME%\lpgexe\lpg.exe -backtrack -list LightweightTypeParser.lpg

FOR %%F IN (*sym.java,*prs.java) DO  %LPG_HOME%\..\perl\perl.exe %QVT_GRAMMAR%\patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (*.java_nls) DO  move /Y %%F %%~nF.java

goto end


:home_dir_notFound
echo ERROR: Env variable 'LPG_HOME=%LPG_HOME%' doesn't point to existing directory!
goto end

:no_home_var
echo ERROR: Setup LPG_HOME env variable to point to LPG distribution directory!
goto end


:end
