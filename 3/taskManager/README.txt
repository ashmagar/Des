CS542 Design Patterns
Spring 2015
ASSIGNMENT 3 README FILE

Due Date: Friday, April 3, 2015
Submission Date: Friday, April 3, 2015
Grace Period Used This Project: 0 days
Grace Period Remaining: 0 days
Author(s): Ashish Magar
e-mail(s): amagar1@binghamton.edu


PURPOSE:

Develop a file based dashboard for a TaskManager using custom observer pattern.

PERCENT COMPLETE:

I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

None of the parts are missing.

BUGS:

None

FILES:

	DisplayFile.java: An interface to print output to file from observers
	Driver.java: To drive the program, contains main
	DashboardFilter.java: Filter interface
	Observer.java: Observer interface
	PerformanceTab.java: Performance tab observer
	PerformanceTabFilterImpl.java: Filter for performance observer
	ProcessesTab.java: Processes tab observer
	ProcessesTabFilterImpl.java: Filter for Processes tab observer
	UsersTab.java: User tab observer
	UserTabFilterImpl.java: Filter for user tab observer
	DashBoardSubject.java: Subject
	Subject.java: Subject interface
	FileProcessor.java: To read from and write to file
	Message.java: Message is being passed to observer from subject
	MessageInterface.java: Interface for message, type of message can change in future, so.
	MyLogger.java: This is an utility class which is used to print to stdout depending on its value. 
			0 -> prints nothing,
			1 -> prints content being written to file,
			2 -> prints message when file descriptors are getting opened and closed
			3 -> prints everytime a method other than a constructor is called, 
			4 -> prints everytime a constructor is called.
	README : A txt file which decribes the given assignment.


SAMPLE OUTPUT:

---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1364884  Memory  Free: 693480  Memory  Cached: 1090952
CPU Idle: 94.9  CPU User Level: 4.3  CPU System Level: 0.5

---USERS---
User: (unknown)  Status: inactive
User: root  Status: inactive
User: dgolemb1  Status: active
User: mslocum1  Status: active
User: ndangwa1  Status: active
User: awiesin1  Status: active
User: bsendir1  Status: active
User: tkargul1  Status: active
User: rashong1  Status: active
User: dgolemb1  Status: active
User: cigdebe1  Status: active


---PROCESSES---
 1881 gdb             dgolemb1  0.0  0.7
 3203 Xorg            root      0.0  0.1
 3994 getty           root      0.0  0.0
 3995 getty           root      0.0  0.0
 3996 getty           root      0.0  0.0
 3997 getty           root      0.0  0.0
 3998 getty           root      0.0  0.0
 3999 getty           root      0.0  0.0
 5393 tcsh            ndangwa1  0.0  0.1
 5975 tcsh            dgolemb1  0.0  0.1
 7377 bash            root      0.0  0.0
 7581 watch           root      0.0  0.0
17264 gdb             dgolemb1  0.0  0.7
17528 tcsh            bsendir1  0.0  0.1
17674 bomb            dgolemb1  0.0  0.0
18090 tcsh            tkargul1  0.0  0.1
18108 nano            ndangwa1  0.7  0.2
18116 tcsh            dgolemb1  0.0  0.1
18151 python          bsendir1  1.1  0.4
18196 sh              bsendir1  0.0  0.0
18197 ps              bsendir1  0.0  0.0
18666 bash            mslocum1  0.0  0.1
27983 vim             mslocum1  0.0  0.8
28029 tcsh            cigdebe1  0.0  0.1
30920 tcsh            rashong1  0.0  0.1
31023 gdb             rashong1  0.0  0.7
31358 bomb            rashong1  0.0  0.0
31444 tcsh            awiesin1  0.0  0.1
32380 emacs           awiesin1  0.0  0.9


---TAB(s) END---


TO COMPILE:

	ant -buildfile src/build.xml all

TO RUN:

	ant -buildfile src/build.xml run -Darg1 = <input file> -Darg2 = <output file> -Darg3 = debug level
	
EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:


ACKNOWLEDGEMENT:

	None.