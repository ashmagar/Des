Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run, edit the build.xml to enter args (search for arg0, arg1, etc.)
ant -buildfile src/build.xml run 


## To create tarball for submission
ant -buildfile src/build.xml tarzip


