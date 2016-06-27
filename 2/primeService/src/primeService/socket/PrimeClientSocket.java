package primeService.socket;

import java.io.IOException;
import java.net.Socket;

import primeService.util.Debug;

public class PrimeClientSocket {

	int port;
	String hostname;
	Socket socket = null;
	PrimeClientWorker pcWorker;
	public PrimeClientSocket(int portIn, String hostnameIn) {
		Debug.printToStdout(4," [constructor of  PrimeClientSocket.java called]");
		this.port = portIn;
		this.hostname = hostnameIn;
		try {
			socket = new Socket(hostname, port);
			pcWorker = new PrimeClientWorker(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Server not found");
		}
	}

	public void primeClientSocket(String query) {
		Debug.printToStdout(3," [method primeClientSocket of PrimeClientSocket.java called]");
		pcWorker.clientWorker(query);
		//socket.close();

		
	}
}
