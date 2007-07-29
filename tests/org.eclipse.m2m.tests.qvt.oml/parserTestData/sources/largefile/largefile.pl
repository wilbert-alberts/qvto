#!perl -w
use strict;

my $text = <<header;
transformation largefile;
metamodel 'http://www.eclipse.org/emf/2002/Ecore';
header
	
print "$text\n";

for(my $i = 0; $i < 1500; $i++) {
	print "query foo$i(): String {\n    'foo$i'\n}\n";
}
