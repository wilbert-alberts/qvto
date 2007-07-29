set HOME=N:\stuff\LPG\lpgdistribution
set LPG_INCLUDE=%HOME%\include;.;
set LPG_TEMPLATE=%HOME%\templates;
%HOME%\lpgexe\lpg.exe -list QvtOpLPGParser.g
rem %HOME%\lpgexe\lpg.exe -soft-keywords -backtrack -list QvtOpLPGParser.backtrack.g
%HOME%\lpgexe\lpg.exe -backtrack -list QvtOpLPGParser.backtrack.g

pause