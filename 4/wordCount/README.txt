CS542 Design Patterns
Spring 2015
ASSIGNMENT 4 README FILE

Due Date: Wednesday, April 22, 2015
Submission Date: Wednesday, April 22, 2015
Grace Period Used This Project: 0 days
Grace Period Remaining: 0 days
Author(s): Ashish Magar
e-mail(s): amagar1@binghamton.edu


PURPOSE:

Using visitors with trees.

PERCENT COMPLETE:

I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

None of the parts are missing.

BUGS:

None

FILES:

	Driver.java: To drive the program, contains main
	PopulateTreeVisitor.java: A visitor class used to populate tree with words
	Visitor.java: A visitor interface implemented by all possible visitors
	WordCountVisitor.java: A visitor class which counts words, unique words and characters and write to file
	MyTree.java: Tree data structure, data structure used is TreeMap
	MyNodeValues.java: Data of nodes to be stored in tree, contains wordcount and charactercount for a word
	FileProcessor.java: To read from and write to file
	MyLogger.java: This is an utility class which is used to print to stdout depending on its value. 
			0 -> prints nothing,
			1 -> prints content to be displayed on console,
			2 -> reserved
			3 -> prints everytime a method other than a constructor is called, 
			4 -> prints everytime a constructor is called.
	README : A txt file which decribes the given assignment.
	build.xml
	run.sh
	
SAMPLE OUTPUT:
	In G7 Lab, on Debian PODs
	For 10M -> 4 sec
	For 40M -> 17 sec
	For 100M -> 40 sec 
	
TO COMPILE AND RUN:

	./run.sh <input_file> <output_file> <no_of_iterations> <logger_level>
	
EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:

	N/A
ACKNOWLEDGEMENT:

	N/A

ABOUT DATA_STRUCTURE AND PERFORMANCE
	The Tree data structure used is TreeMap provided by java in java.util.TreeMap<K,V>.
	This implementation has adopted red-black tree implementation.
	This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
	Algorithms are adaptations of those in Cormen, Leiserson, and Rivest's Introduction to Algorithms.
	As log(n) could be the fastest possible way to access any element of tree, this data structure is one of 
	the best data structure could be used for trees.
	A red-black tree is a particular implementation of a self-balancing binary search tree. It is possible to
	use AVL tree but AVL has slight more overhead in terms of insertions whereas the search cost is almost the
	same. Red-black trees are normally faster than AVL trees because there is no need to go up the tree after inserting 
	or deleting. As it is written in assignment statement that use the tree data structure that will maximize performance
	for the second visitor, I preferred this over BST, because in worst case if the data (input file) is sorted 
	(alphabetically) then performance will have tremendous impact. Also Red-Black tree has Relatively low constants
	in a wide variety of scenarios.
	In each operation we do at most 3 rotations (and O(log n) colour changes, which are quick); this allows creation
	of efficient persistent data structures
