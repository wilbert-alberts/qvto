#*******************************************************************************
# Copyright (c) 2013 E.D.Willink and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     E.D.Willink - initial API and implementation
#*******************************************************************************
#!/bin/bash

mv buildroot/buckminster.output/org.eclipse.qvto.releng.build_*-eclipse.feature/site.p2 QVTo.p2.repository
mv buildroot/buckminster.output/org.eclipse.qvto.releng.build_*-eclipse.feature/zips QVTo.downloads

if [ ${MANAGE_JAVADOC:="false"} = "true" ]
then
  mkdir QVTo.javadoc
  mv buildroot/buckminster.output/org.eclipse.qvto.releng.buckminster_*-buckminster/javadoc/QVTo-javadoc.zip QVTo.javadoc/QVTo-javadoc.zip
  rm -rf buildroot/buckminster.output/org.eclipse.qvto.releng.buckminster_*-buckminster/javadoc
fi
