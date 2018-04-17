import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private static ServerSocket server ;
	
	public static void main(String[] args) {
		//teste
		  try{
		    server = new ServerSocket(1989);
		    System.out.println("Servidor iniciado na porta: " + server.getLocalPort());
		  } catch (IOException e) {
		    System.out.println(server.getLocalPort());
		    System.exit(-1);
		  }
		  for(int i=0;i<20;i++){
		    ClientWorker w;
		    Socket cliente;
		    try{
		      //Pra cada conexao do cliente, cria uma thread
		      cliente = server.accept();
		      w = new ClientWorker(cliente);
		      Thread t = new Thread(w);
		      t.start();
		    } catch (IOException e) {
		      System.out.println("Falha ao aceitar porta: " + server.getLocalPort());
		      System.exit(-1);
		    }
		  }
		  try{
		        server.close();
		    } catch (IOException e) {
		        System.out.println("Nao foi possivel fechar o socket");
		        System.exit(-1);
		    }
		}

}
