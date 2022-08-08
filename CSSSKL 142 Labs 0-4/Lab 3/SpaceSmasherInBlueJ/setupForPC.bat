REM GTCS one-time bootstraps script for PC users
REM This script will copy a needed library into a shared user library directory
REM that is loaded automatically when blueJ starts up.
REM Note that you need to run this as an administrator, since we're copying files
REM to the "Program Files" directory...


@echo off
IF _%1_==_payload_  GOTO :doElevatedTask

REM Here is where we build a temp VB script to grab admin permissions
:getadmin
    set vbs=%temp%\getadmin.vbs
    echo Set UAC = CreateObject^("Shell.Application"^)                >> "%vbs%"
    echo UAC.ShellExecute "%~s0", "payload %~sdp0 %*", "", "runas", 1 >> "%vbs%"
    "%temp%\getadmin.vbs"
    del "%temp%\getadmin.vbs"
    REM The script is removed after being executed
goto :done


REM actual file copy occurs in the second batch file
:doElevatedTask
    cd /d %2
    fileCopy_PC.bat 
    REM goto :done
:done
echo All done!
