package primeService.client;

import java.util.Scanner;

import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;

public class ClientDriver {

	int port;
	String hostname;
	String clientName;
	String query;
	boolean flag;
	int numberToQuery;
	protected PrimeClientSocket pcSocket = null;
	
	public ClientDriver(int portIn, String hostnameIn) {
		Debug.printToStdout(4," [Constructor of ClientDriver.java called]");	
		
		this.port = portIn;
		this.hostname = hostnameIn;
		pcSocket = new PrimeClientSocket(port,hostname);
	}
	
	public void clientDriver()
	{
		Debug.printToStdout(3," [method clientDriver of ClientDriver.java called]");	
		Scanner in;// = new Scanner(System.in);
		int choice;
		while(true)
		{
			ClientMenu.displayMenu();
			in = new Scanner(System.in);
			choice = Integer.parseInt(in.nextLine());
			if(choice==4) break;
			switch(choice)
			{
					case 1: 
							//Send data over socket
							System.out.println("Enter Name: ");
							clientName = in.nextLine();
							//System.out.println("Sending packet....");
							//out.println("Sending packet....");
							break;

			
					case 2:
						System.out.println("Enter Number: ");
						if(clientName != null)
						{
							try{ numberToQuery = in.nextInt();
							}catch(NumberFormatException e) { System.err.println("Invalid num");}
							query = "<primeQuery> <clientName> " + clientName + " </clientName> <isPrime> " + numberToQuery + " </isPrime> </primeQuery> 2";
							flag=true;
							pcSocket.primeClientSocket(query);
							break;
						}	
					case 3:
						if(clientName != null && flag == true)
							{
								query = "<primeQuery> <clientName> " + clientName + " </clientName> <isPrime> " + numberToQuery + " </isPrime> </primeQuery> 3";
								pcSocket.primeClientSocket(query);
							}
							break;
							
					default:
							System.out.println("Invalid choice");

			}
			//if(choice!=1) { pcSocket.primeClientSocket(query,choice); }
			//else pcSocket.primeClientSocket(choice,in);
//			in.close();
		}
		in.close();
		
	}

}
