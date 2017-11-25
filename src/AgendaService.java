import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

public class AgendaService implements Container{
	
	@Override
	public void handle(Request request, Response response) {
		try {
			PrintStream body = response.getPrintStream();

			response.setValue("Content-Type", "application/json");
//			body.println("Diretório: "+ request.getPath().getDirectory());
//			body.println("Tipo: "+ request.getPath().getName());
			
			body.println();
			body.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] list) throws Exception {
		
		int porta = 880;

		Container container = new AgendaService();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();
   }
}
