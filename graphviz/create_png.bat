@echo off 
cd C:\Users\wang\Desktop\graphTree
dot binarytree.gv | gvpr -c -ftree.gv | neato -n -Tpng -o binarytree.png
pause