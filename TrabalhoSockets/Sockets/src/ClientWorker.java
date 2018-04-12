import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientWorker implements Runnable {
	private Socket client;

	//Constructor
	  ClientWorker(Socket client) {
	    this.client = client;
	  }

	  public void run(){
		System.out.println("Rodando Thread pro cliente");
	    String line;
	    BufferedReader in = null;
	    PrintWriter out = null;
	    try{
	      in = new BufferedReader(new 
	        InputStreamReader(client.getInputStream()));
	      out = new 
	        PrintWriter(client.getOutputStream(), true);
	    } catch (IOException e) {
	      System.out.println("in or out failed");
	      System.exit(-1);
	    }

	    while(true){
	      try{
	    	//Le o que foi enviado pelo cliente
	        line = in.readLine();
	        //Envia de volta
	        out.println(line);
	        out.flush();
	        System.out.println("Recebido: " + line);
	        
	        out.close();
	        in.close();
	        client.close();
	        
	       }catch (IOException e) {
	        System.out.println("A leitura falhou");
	        System.exit(-1);
	       }
	    }
	  }
}
