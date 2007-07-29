#perl -w
use strict;
while(<>) {
	if(m{transformation\s+([^;]+);}) {
		print "transformation models.$1.$1;\n"
	}
	else {
		print;
	}
}
