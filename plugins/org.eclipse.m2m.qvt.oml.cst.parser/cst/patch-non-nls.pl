#!/usr/bin/perl

while (<>) {
  if ($_ =~ /.*\".*\"\,*/) {
    chomp $_;
    print $_, ' //$NON-NLS-1$', "\n";
  }
  else {
    print $_;
  }
}