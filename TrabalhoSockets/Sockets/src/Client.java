import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	private static PrintWriter out;
	private static BufferedReader in;
	private static Socket cliente;
	
	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	
		try{
			cliente = new Socket("localhost",4321);
			System.out.println("Usando o socket localhost na porta 4321");
			out = new PrintWriter(cliente.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String text = read.readLine(); //Le o que foi digitado
			out.println(text); //envia pro servidor
			System.out.println(in.readLine()); //leu a resposta do servidor
			}catch (UnknownHostException e) {
			     System.out.println("Unknown host: localhost");
			     System.exit(1);
			}catch(Exception e) {
			      System.out.println("Erro: " + e.getMessage());
			      System.exit(1);
		    }finally{
		    	out.close();
		        try {
					in.close();
			        read.close();
			        cliente.close();
				} catch (IOException e) {
					System.out.println("Não foi possível fechar o socket");
			        System.exit(-1);
				}

		    }
		
		

	}
	

	
	
}