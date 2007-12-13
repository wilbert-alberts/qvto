set HOME=N:\stuff\LPG\lpgdistribution

set QVT_GRAMMAR=N:\eclipse_dev_becher\eclipse\becher\org.eclipse.m2m.qvt.oml\src\org\eclipse\m2m\qvt\oml\internal\cst\parser
copy %QVT_GRAMMAR%\*.g %cd%
%HOME%\lpgexe\lpg.exe -backtrack -list LightweightParser.lpg
%HOME%\lpgexe\lpg.exe -backtrack -list LightweightTypeParser.lpg
del *.g
rem del *.l

pause