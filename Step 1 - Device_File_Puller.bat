color 1F
@echo off
cls

echo.
echo.
echo ****************************************************************************
echo					Android File Puller
echo.
echo 	Pulls all files off a andriod device that is connected
echo 	to your windows machine.
echo.			
echo		File locations: ..\phoneData\%loc%
echo.
echo		Note: Phone must be rooted and in USB debugging mode!
echo ****************************************************************************
echo.
echo.
echo.
pause

SET /P loc=Name of directory to be created?: %
mkdir phoneData\%loc%

cd adb
adb pull cache ..\phoneData\%loc%\cache
adb pull acct ..\phoneData\%loc%\acct
adb pull system ..\phoneData\%loc%\system
adb pull sys ..\phoneData\%loc%\sys
adb pull sbin ..\phoneData\%loc%\sbin
adb pull data ..\phoneData\%loc%\data
adb pull dev ..\phoneData\%loc%\dev
adb pull proc ..\phoneData\%loc%\proc

pause













