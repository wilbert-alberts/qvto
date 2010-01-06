#!/usr/bin/perl

while (<>) {
  if ($_ =~ /.*\".*\"\,*/  &&  !($_ =~ /\@SuppressWarnings\(\"unchecked\"\)/)) {
    chomp $_;
    print $_, ' //$NON-NLS-1$', "\n";
  }
  else {
    print $_;
  }
}