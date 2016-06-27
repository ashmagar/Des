package primeService.server;

import java.util.Scanner;

import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

public class ServerDriver {

	int port;
	public ServerDriver(int portIn) {
		Debug.printToStdout(4," [constructor of  ServerDriver.java called]");
		this.port = portIn;
	}

	public void serverDriver()
	{
		Debug.printToStdout(3," [method serverDriver of  ServerDriver.java called]");
		PrimeServerSocket server = new PrimeServerSocket(port);
		new Thread(server).start();
			
		Scanner in;// = new Scanner(System.in);
		int choice;
		while(true)
		{
			ServerMenu.displayMenu();
			in = new Scanner(System.in);
			choice = Integer.parseInt(in.nextLine());
			if(choice==3) break;
			switch(choice)
			{
					case 1:
							String clientNameIn = in.nextLine();
							AllPrimeQueries.printQuery(clientNameIn);
							break;
					case 2:
							AllPrimeQueries.printAllQueries();
							break;
					default:
							System.out.println("Enter Correct Choicce");
	
			}
							
	
		//System.out.println("Stopping Server");
		}
		in.close();
		
		
		server.closeSocket();
		
		
	}
}
