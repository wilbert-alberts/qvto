@echo off

if not defined LPG_HOME goto no_home_var
if not exist %LPG_HOME% goto home_dir_notFound

set LPG_INCLUDE=%LPG_HOME%\include;.;
set LPG_TEMPLATE=%LPG_HOME%\templates;

rem %LPG_HOME%\lpgexe\lpg.exe -soft-keywords -backtrack -list QvtOpLPGParser.backtrack.g
%LPG_HOME%\lpgexe\lpg.exe -backtrack -list QvtOpLPGParser.backtrack.g
goto end

:home_dir_notFound
echo ERROR: Env variable 'LPG_HOME=%LPG_HOME%' doesn't point to existing directory!
goto end

:no_home_var
echo ERROR: Setup LPG_HOME env variable to point to LPG distribution directory!
goto end


:end