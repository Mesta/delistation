@echo off
set PROJECT_PATH=G:\workspace\delistation
setlocal EnableDelayedExpansion

echo Lancement de G_Colis dans la zone 1 - 1
set PARAM_JAVA=";17;rue Al Capone 31400 Blagnac;1;1"
start "G_Colis 1 - 1" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

echo Lancement de G_Colis dans la zone 1 - 2
set PARAM_JAVA=";65;chemin de kleenex 31400 Blagnac;1;2"
start "G_Colis 1 - 2" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

echo Lancement de G_Colis dans la zone 2 - 1
set PARAM_JAVA=";17;Impasse de la galipette 31500 ;2;1"
start "G_Colis 2 - 1" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

echo Lancement de G_Colis dans la zone 2 - 2
set PARAM_JAVA=";17;Allée youplaboom 31500 Toulouse;2;2"
start "G_Colis 2 - 2" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

echo Lancement de G_Colis dans la zone 3 - 1
set PARAM_JAVA=";17;La croisée Durotar;3;1"
start "G_Colis 3 - 1" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

echo Lancement de G_Colis dans la zone 3 - 2
set PARAM_JAVA=";17;Chez Moe's Toulouse;3;2"
start "G_Colis 3 - 2" /min %PROJECT_PATH%\launcher\scripts\G_Colis.bat %PARAM_JAVA% %PROJECT_PATH%

pause