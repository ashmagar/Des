#!/bin/bash +vx
#usage ./run <input> <Num Iterations> <Debug Value>
#It assumes that build file placed in src/wordCount/build.xml
if test "$#" -ne 3; then
        echo "Wrong number of arguments!"
        echo "usage ./run <input> <Num Iterations> <Debug Value>"
else
        echo "ant -buildfile build.xml all"
        ant -buildfile build.xml all
		echo ""
        echo ""
        echo "ant run -buildfile src/objComp/build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3"
        echo ""
        ant run -buildfile build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3
        echo ""
        echo ""
fi