%options escape=$
%options la=2
%options table=java
%options fp=LightweightTypeParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
--%options template=dtParserTemplateD.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable

%Start
    QvtLwGoal
%End

%Import
	../QVTOParser.gi

%Globals
	/.
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParserprs;
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;	
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	
	./
%End


%Rules
	QvtLwGoal -> typespec
%End