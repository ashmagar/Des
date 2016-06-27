package primeService.driver;

import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;

public class PrimeDriver {

	public static void main(String[] args)
	{

		if(args[0].equalsIgnoreCase("server"))
		{
			new ServerDriver(Integer.parseInt(args[1])).serverDriver();
			try {
				Debug.setDebugValue(args[2]);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.err.println("Please Enter valid integer NUMBER for debug level");
			}

		}
		
		else if(args[0].equalsIgnoreCase("client"))
		{
			new ClientDriver(Integer.parseInt(args[1]), args[2]).clientDriver();
			try {
				Debug.setDebugValue(args[3]);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.err.println("Please Enter valid integer NUMBER for debug level");
			}

		}

	}
	
}
