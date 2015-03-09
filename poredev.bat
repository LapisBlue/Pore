@echo off

rem This will make my life easier while converting to Batch
set dirname=%CD%
for /F "delims=" %%i in (%filepath%) do set filename="%%~nxi"
for /F "delims=" %%i in (%filepath%) do set basename="%%~ni"
set project=Porekit

GOTO :begin

:pore_help
    echo Usage^: %0 ^<command^>
    echo Available commands^:
	echo.
    echo   help - Show this help page.
    echo   update - Update the submodules and apply the Porekit patches.
    echo   patches - Rebuild the Porekit patches.
GOTO :EOF

:apply_patches
    rem Based on https://hub.spigotmc.org/stash/projects/SPIGOT/repos/spigot/browse/applyPatches.sh#7
    set source=%1
    for /F %%i in ("%source%") do set repo=%%~ni
    set target=%2
    set patchdir=%3
    if !"%4"==""! (
	    set branch="%4"
	)
	if "%4"=="" (
		set branch="origin/master"
	)

    cd "%dirname%\%source%"
    git reset --hard "%branch%" > NUL
    git branch -f upstream > NUL

    cd "%dirname%"
    if not exist "%dirname%\%target%" ( git clone "%source%" "%target%" -b upstream )

    cd "%dirname%\%target%"

    echo ^>^> Resetting %target% to %repo%...
    git remote rm upstream > NUL 2>&1
    git remote add upstream "..\%source%" > NUL 2>&1
    git checkout master > NUL 2>&1
    git fetch upstream > NUL 2>&1
    git reset --hard upstream/upstream

    echo ^>^> Applying patches to %target%...
    git am --abort > NUL 2>&1
	set files=
	
	for /f %%i in ('dir /b "%dirname%\%patchdir%\*.patch"') do call :add_file %dirname%\%patchdir%\%%i
    git am --3way %files% || echo ^>^> Failed to apply patches to %target% ^(from %source%^)

    echo ^>^> Successfully applied patches to %repo%
GOTO :EOF

:pore_update
    echo ^> Updating submodules...
    git submodule update --init
    echo ^> Updating %project%...
    call :apply_patches lib\Bukkit %project% patches
GOTO :EOF


:clean_patches
    rem Based on https://hub.spigotmc.org/stash/projects/SPIGOT/repos/spigot/browse/rebuildPatches.sh#7
	setlocal enableDelayedExpansion
    for /f %%p in ('dir /b /s %1\*.patch') do (
		SET gitver=tail -n 2 %%p | grep -ve "^$" | tail -n 1
        SET diffs=git diff --staged %%p | grep -E "^(\+|\-)" | grep -Ev "(From [a-z0-9]{32,}|\-\-\- a|\+\+\+ b|.index)"

        SET testver=echo "%diffs%" | tail -n 2 | grep -ve "^$" | tail -n 1 | grep "%gitver%"
        if !"x%testver%"=="x"! (
            SET diffs=echo "%diffs%" | head -n -2
        )

        if "x%diffs%"=="x" (
            git reset HEAD %%p > NUL
            git checkout -- %%p > NUL
        )
	)
	endlocal
GOTO :EOF

:make_patches
    rem Based on https://hub.spigotmc.org/stash/projects/SPIGOT/repos/spigot/browse/rebuildPatches.sh#26
    set source=%1
    for /F %%i in ("%source%") do set repo=%%~ni
    set target=%2
    set patchdir=%3

    echo ^>^> Creating patches from %repo% to %target%...
    cd "%dirname%\%target%"
    git format-patch --no-stat -N -o "%dirname%\%patchdir%" upstream/upstream
    cd "%dirname%"
    git add -A "%dirname%\%patchdir%"
    call :clean_patches "%dirname%\%patchdir%"
    echo ^>^> Successfully saved patches for %repo%!
GOTO :EOF

:pore_patches
    echo ^> Recreating patches for %project%...
    call :make_patches lib\Bukkit %project% patches
GOTO :EOF

if !%1==! (
    call :pore_help
    GOTO :EOF
)

:head
setlocal EnableDelayedExpansion
set /a counter=0

for /f ^"usebackq^ eol^=^

^ delims^=^" %%a in (%1) do (
        if "!counter!"=="%2" goto :eof
        echo %%a
        set /a counter+=1
)
goto :eof

:tail
SETlocal EnableExtensions
SET tailCount=%%2
SET fileName=del_temp.log
SET output=value.log
FOR /F "usebackq tokens=3,3 delims= " %%l IN (`find /c /v "" %fileName%`) DO (call SET find_lc=%%l)
SET /a linenumber = %find_lc% – %tailCount%
IF %linenumber% LSS 1 (
more +0 %fileName% >> %output%
) ELSE (
more +%linenumber% %fileName% >> %output%
)
endLocal
GOTO :EOF

:add_file
    set files=%files% %1
GOTO :EOF

:begin
rem TODO: Improve this, just a little bit lazy right now
findstr /i /r /c:"^[ ]*:pore_%1\>" "%~f0" > NUL || GOTO unknown_command
call :pore_%1
cd %dirname%
GOTO :EOF
:unknown_command
>&2 echo Unknown command: '%1'. Type '%0 help' for more information.
