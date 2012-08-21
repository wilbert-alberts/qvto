#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.qvto.releng.build_*-eclipse.feature/site.p2 MMT-QVTo.p2.repository
mv buildroot/buckminster.output/org.eclipse.qvto.releng.build_*-eclipse.feature/zips MMT-QVTo.downloads

if [ ${MANAGE_JAVADOC} = "true" ]
then
  mkdir MMT-QVTo.javadoc
  mv buildroot/buckminster.output/org.eclipse.qvto.releng.buckminster_*-buckminster/javadoc/MMT-QVTo-javadoc.zip MMT-QVTo.javadoc/MMT-QVTo-javadoc.zip
#  rm -rf buildroot/buckminster.output/org.eclipse.qvto.releng.buckminster_*-buckminster/javadoc
fi
