package primeService.server;

import primeService.util.Debug;

public class ServerMenu {

	public static void displayMenu()
	{
		Debug.printToStdout(3," [method displayMenu of  ServerMenu.java called]");
		System.out.println("Server Menu:");
		System.out.println("1. Client Name");
		System.out.println("2. All Client Queries");
		System.out.println("3. Quit");
	}

}
