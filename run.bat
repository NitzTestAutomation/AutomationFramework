@echo off
set RUNTYPE=%1
set XMLFILEPATH=%2
set ENV=%3
set BROWSER=%4


echo Run type is: %RUNTYPE%
echo XML file path is: %XMLFILEPATH%
echo Environment is: %ENV%
echo Browser is: %BROWSER%

echo mvn clean test "-DexecutionType=%RUNTYPE%" "-DsuiteXmlFile=%XMLFILEPATH%" "-Denv=%ENV%" "-Denv=%BROWSER%"

mvn clean test -DexecutionType=%RUNTYPE% -DsuiteXmlFile=%XMLFILEPATH%  -Denv=%ENV% -Dbrowser=%BROWSER%