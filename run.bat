@echo off

call javac -encoding utf8 "@compile.list"

echo Lancement du programme...
call java -cp ./bin controleur.Controleur

echo Fin de l'execution.
goto :eof