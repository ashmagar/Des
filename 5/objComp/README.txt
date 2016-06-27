CS542 Design Patterns
Spring 2015
ASSIGNMENT 5 README FILE

Due Date: Monday, May 4, 2015
Submission Date: Monday, May 4, 2015
Grace Period Used This Project: 0 days
Grace Period Remaining: 0 days
Author(s): Ashish Magar
e-mail(s): amagar1@binghamton.edu


PURPOSE:

Comparing Objects in Java.

PERCENT COMPLETE:

I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

None of the parts are missing.

BUGS:

None

FILES:

	Driver.java: To drive the program, contains main
	FileProcessor.java: To read from and write to file
	First.java: One of the class whose instance will be created and methods will be called
	Second.java: Another class whose instance will be created and methods will be called
	PopulateObjects.java: Uses java reflection to create instance of the classes in input file
						  Takes parameters, method names and values and calls the respective methods
						It also populates the object in data structure, in this case HashMap
	MyLogger.java: This is an utility class which is used to print to stdout depending on its value. 
			0 -> prints output to console,
			1 -> prints prints when overridden methods equals and hashcode are called,
			2 -> prints when file stream is opened and closed
			3 -> prints everytime a method other than a constructor is called, 
			4 -> prints everytime a constructor is called.
	README : A txt file which decribes the given assignment.
	build.xml
	run.sh
	
SAMPLE OUTPUT:
		NONE
		
TO COMPILE AND RUN:

	./run.sh <input_file> <no_of_iterations> <logger_level>
	
EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:

	N/A
ACKNOWLEDGEMENT:

	N/A

ABOUT DATA_STRUCTURE AND PERFORMANCE
	The data structure used is HashMap provided by Java in java.util.HashMap<K,V>.
	This implementation provides guaranteed O(1) time cost for the search operation.
	The assignment requires to count number of instance of the objects and whether there
	are any duplicates, if we use HashMap then it would be easiest and most efficient way
	to keep track of duplicate objects. Hence I used HashMap as a data structure.
	