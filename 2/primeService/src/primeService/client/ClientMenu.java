package primeService.client;

import primeService.util.Debug;

public class ClientMenu {
	public static void displayMenu()
	{
		Debug.printToStdout(3," [method displayMenu of ClientMenu.java called]");	
		System.out.println("Client Menu:");
		System.out.println("1. Set Client Name");
		System.out.println("2. Enter number to query for prime");
		System.out.println("3. Server Response");
		System.out.println("4. Quit");
	}

}
