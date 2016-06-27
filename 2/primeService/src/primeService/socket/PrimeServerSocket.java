package primeService.socket;
import java.io.IOException;
import java.net.ServerSocket;

import primeService.util.Debug;

public class PrimeServerSocket implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected String serverText 		= null;
   
    public PrimeServerSocket(int port){
    	Debug.printToStdout(4," [constructor of  PrimeServerSocket.java called]");
        this.serverPort = port;
        this.serverText = new String("abcdefghi");
    	try{
    	    serverSocket = new ServerSocket(serverPort);
    	  } catch (IOException e) {
    	    System.out.println("Could not listen on port " + serverPort);
    	    System.exit(-1);
    	  }

    }

    public void run(){
    	  while(true){
    	    PrimeServerWorker w;
    	    try{
    	//server.accept returns a client connection
    	      w = new PrimeServerWorker(serverSocket.accept(), serverText);
    	      Thread t = new Thread(w);
    	      t.start();
    	    } catch (IOException e) {
    	      System.out.println("Accept failed: " + serverPort);
    	      System.exit(-1);
    	    }
    	  }
   }
     

public void closeSocket() {
	Debug.printToStdout(3," [method closeSocket of PrimeServerSocket.java called]");
	// TODO Auto-generated method stub
	try {
		serverSocket.close();
	} catch (IOException e) {
		//e.printStackTrace();
		System.err.println("Server Closed !!!!!!");
	}
	
}
}