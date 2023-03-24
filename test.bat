@echo off

call javac -encoding utf8 "@compile.list"

echo Lancement du programme...
call java -cp ./bin metier.reseau.ServerUDP

echo Fin de l'execution.
goto :eof