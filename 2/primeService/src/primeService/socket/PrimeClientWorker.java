package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.util.Debug;

public class PrimeClientWorker {

	protected Socket socket = null;
	protected String clientName = null;
	String response;
	String[] queryTokens;
	public PrimeClientWorker(Socket socketIn) {
		Debug.printToStdout(4," [constructor of  PrimeClientWorker.java called]");
		this.socket = socketIn;
		
	}
	public void clientWorker(String query) {
		Debug.printToStdout(3," [method clientWorker of  PrimeClientWorker.java called]");
		// TODO Auto-generated method stub
		PrintWriter out = null;
		BufferedReader in = null;
//		Scanner sysIn = new Scanner(System.in);
		try{
			out = new PrintWriter(socket.getOutputStream(),true);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//System.out.println(query);
			out.println(query);
		
	        queryTokens = query.split(" ");
	        if(Integer.parseInt(queryTokens[8])==3)
	        	{
	        		response = in.readLine();
	        		System.out.println(response);
	        	}
		
		} catch  (IOException e) {
			     System.out.println("No I/O");
			     System.exit(1);
			   }

	}
	

}
