#!/bin/sh

find . -name *.java > sources.txt
javac @sources.txt

cd src/simulator
java Simulator scenario.txt
