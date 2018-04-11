import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JTextArea;

public class Server {
	private static ServerSocket server;
	private static JTextArea textArea;
	
	public static void main(String[] args) {
		listenSocket();
	}
	public static void listenSocket(){
		  try{
		    server = new ServerSocket(3322);
		  } catch (IOException e) {
		    System.out.println("Could not listen on port 3322");
		    System.exit(-1);
		  }
		  while(true){
		    ClientWorker w;
		    try{
		//server.accept returns a client connection
		      w = new ClientWorker(server.accept(), textArea);
		      Thread t = new Thread(w);
		      t.start();
		    } catch (IOException e) {
		      System.out.println("Accept failed: 3322");
		      System.exit(-1);
		    }
		  }
		}

	protected void finalize(){
		//Objects created in run method are finalized when
		//program terminates and thread exits
		     try{
		        server.close();
		    } catch (IOException e) {
		        System.out.println("Could not close socket");
		        System.exit(-1);
		    }
		  }
}
