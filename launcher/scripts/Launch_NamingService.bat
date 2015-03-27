@echo off
set PROJET_PATH=%1
set OPENORB_PATH=%PROJET_PATH%\openorb

set CLASSPATH=%PROJET_PATH%\bin;%PROJET_PATH%\lib\junit-4.11.jar;%PROJET_PATH%\lib\mysql-connector-java-5.1.30-bin.jar;%PROJET_PATH%\lib\openorb\lib\avalon-framework.jar;%PROJET_PATH%\lib\openorb\lib\excalibur-configuration.jar;%PROJET_PATH%\lib\openorb\lib\logkit.jar;%PROJET_PATH%\lib\openorb\lib\openorb_examples-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\openorb_test-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\openorb_tools-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\openorb-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\xerces.jar;%PROJET_PATH%\lib\openorb\lib\junit.jar;%PROJET_PATH%\lib\hamcrest-core-1.3.jar;%PROJET_PATH%\lib\jaxen-1.1.6.jar;%PROJET_PATH%\lib\jdom-2.0.5-contrib.jar;%PROJET_PATH%\lib\jdom-2.0.5-javadoc.jar;%PROJET_PATH%\lib\jdom-2.0.5-junit.jar;%PROJET_PATH%\lib\jdom-2.0.5-sources.jar;%PROJET_PATH%\lib\jdom-2.0.5.jar;%PROJET_PATH%\lib\xercesImpl.jar;%PROJET_PATH%\lib\xml-apis.jar

cd %PROJET_PATH%
%JAVA_HOME%\bin\java -classpath %CLASSPATH% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB org.openorb.util.MapNamingContext -ORBPort=2001 -print -printIOR
pause