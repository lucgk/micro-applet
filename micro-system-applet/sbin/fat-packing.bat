@echo off
echo [INFO] Package the jar in target dir.

cd %~dp0
cd ..
call mvn clean package -Dmaven.test.skip=true

cd sbin
pause