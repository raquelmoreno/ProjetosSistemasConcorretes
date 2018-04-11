import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	private static PrintWriter out;
	private static BufferedReader in;
	
	public static void main(String[] args) {
		listening();
	}

	public static void listening() {
		try{
			Socket cliente = new Socket("localhost",3322);
			System.out.println("Usando o socket localhost na porta 3322");
			out = new PrintWriter(cliente.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			}catch (UnknownHostException e) {
			     System.out.println("Unknown host: localhost");
			     System.exit(1);
			}catch(Exception e) {
			      System.out.println("Erro: " + e.getMessage());
			      System.exit(1);
		    } 

	}
	

	
	
}