package primeService.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import primeService.server.AllPrimeQueries;
import primeService.util.CheckPrime;
import primeService.util.Debug;

/**

 */
public class PrimeServerWorker implements Runnable{

	 private Socket client;
	 String serverText = null;
	 private String[] queryTokens;
	 String clientName;
	 int queryNumber;
	 String queryResponse;

	//Constructor
	  PrimeServerWorker(Socket client, String serverTextIn) {
		Debug.printToStdout(4," [constructor of  PrimeServerWorker.java called]");
	    this.client = client;
	    serverText = serverTextIn;
	  }

	  public void run(){
	    String line;
	    BufferedReader in = null;
	    PrintWriter out = null;
	    while(true)
	    {
	    try{
	    
	      in = new BufferedReader(new 
	        InputStreamReader(client.getInputStream()));
	      out = new 
	        PrintWriter(client.getOutputStream(), true);
	              
	      	line = in.readLine();
	        queryTokens = line.split(" ");
	        clientName = queryTokens[2];
	        try{
	        	 queryNumber = Integer.parseInt(queryTokens[5]);
	        }catch(NumberFormatException e)
	        {
	        	out.println("<primeQueryResponse> <intValue> "+ queryTokens[5] + "</intValue> <isPrime> No Idea!! </isPrime> </primeQueryResponse>");
	        	System.err.println("Incorrect number format");
	        }
	        
	        if(Integer.parseInt(queryTokens[8])==2)
	        	{
	        		AllPrimeQueries.insertQuery(clientName,queryNumber);
	        	}
	        if(queryNumber<3)
	        {
	        	queryResponse = "<primeQueryResponse> <intValue> "+ queryNumber + "</intValue> <isPrime> Not Valid </isPrime> </primeQueryResponse>";
	        }
	        else
	        {
		        boolean result = CheckPrime.checkPrime(queryNumber);      	
		        if(result == true) 
		        {
		        	queryResponse = "<primeQueryResponse> <intValue> "+ queryNumber + "</intValue> <isPrime> Prime </isPrime> </primeQueryResponse>";
		        }else
		        {
		        	queryResponse = "<primeQueryResponse> <intValue> "+ queryNumber + "</intValue> <isPrime> Not Prime </isPrime> </primeQueryResponse>";
		        }
		        
		        
		    	//out.println(queryResponse);
		        if(Integer.parseInt(queryTokens[8])==3)
		        {
		        	out.println(queryResponse);
		        }
	        }	

	    } catch (IOException e) {
	      System.err.println("Client Disconnected or exception occurred");
	      
	      break;
	    }
   }
	    	    
	    try {
			client.close();
		} catch (IOException e) {
			  System.err.println("Client Disconnected or exception occurred");
			  System.exit(-1);
		}
	    Thread.currentThread().interrupt();


	  }

/*protected void finalize(){
	//Objects created in run method are finalized when
	//program terminates and thread exits
	     try{
	        client.close();
	    } catch (IOException e) {
	        System.out.println("Could not close socket");
	        System.exit(-1);
	    }
	  } */
}