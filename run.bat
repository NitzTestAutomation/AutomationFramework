@echo off
set RUNTYPE=%1
set XMLFILEPATH=%2
set ENV=%3


echo Run type is: %RUNTYPE%
echo XML file path is: %XMLFILEPATH%
echo Environment is: %ENV%

echo mvn clean test "-DexecutionType=%RUNTYPE%" "-DsuiteXmlFile=%XMLFILEPATH%" "-Denv=%ENV%"

mvn clean test -DexecutionType=%RUNTYPE% -DsuiteXmlFile=%XMLFILEPATH%  -Denv=%ENV%