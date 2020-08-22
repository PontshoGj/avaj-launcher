#!/bin/sh

find . -name *.java > sources.txt
javac -sourcepath @sources.txt

# cd src/simulator
# javac Simulator.java
# java Simulator scenario.txt
