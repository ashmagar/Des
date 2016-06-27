CS542 Design Patterns
Spring 2015
ASSIGNMENT 2 README FILE

Due Date: Monday, March 9, 2015
Submission Date: Monday, March 9, 2015
Grace Period Used This Project: 0 days
Grace Period Remaining: 0 days
Author(s): Ashish Magar
e-mail(s): amagar1@binghamton.edu


PURPOSE:

The purpose of this assignment is to design a simple multi-threaded client-server code in Java and apply the design principles/patterns that have been learned so far. 

PERCENT COMPLETE:

I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

None of the parts are missing.

BUGS:

None

FILES:

	PrimeDriver.java : This is the tester class of the application 
	ClientDriver.java : This is the driver class of the client, which will accept input through command line and open the socket based on the given input.
	ClientMenu.java : This will display the client side menu and perform appropriate options based on the user input.
	ServerDriver.java : This is the server side driver class, which will open a socket and wait for client to connect on that socket.
	ServerMenu.java : This will display the server side menu and perform appropriate operations based on user input.
	AllPrimeQueries.java : This contains the data structure to store all the queries stored sent by the client.
	PrimeClientSocket.java : This creates a Socket with the given hostname and port no. and passes this socket to the PrimeClientSocket.
	PrimeClientWorker.java : This is the worker class on the client side which handles the actual interaction with the server.
	PrimeServerSocket.java : This creates a ServerSocket with the given port no. and waits for a client on this socket. If a client arrives, then it starts the PrimeServerWorker on a new Thread.
	PrimeServerWorker.java : It the the worker class on the server side. It accepts the data sent from the server. Updates the data structure based on the prime no sent from the client and then sends the response back to the client.
	CheckPrime.java : This is a utility class to check whether the given number is a prime number or not.
	Debug.java : This is an utility class which is used to print to stdout depending on its value. 2 -> prints client socket info,
				 3 -> prints everytime a method other than a constructor is called, 4 -> prints everytime a constructor is called.
	README : A txt file which decribes the given assignment.


SAMPLE OUTPUT:

Depends on the client/server interaction.

TO COMPILE:

	ant -buildfile src/build.xml all

TO RUN:

	SERVER: 
	ant -buildfile src/build.xml run -Darg1 = server -Darg2 = 19992 -Darg3 = 3 

	CLIENT: 
	ant -buildfile src/build.xml run -Darg1 = client -Darg2 = localhost -Darg3 = 19992 -Darg4 = 3
	


EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:


ACKNOWLEDGEMENT:

	None.
