import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;

import org.json.JSONObject;
import org.simpleframework.http.Path;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

public class AgendaService implements Container{
	Agenda a = new Agenda();
	
	@Override
	public void handle(Request request, Response response) {
		try {
			PrintStream body = response.getPrintStream();

			response.setValue("Content-Type", "application/json");
			
			redirect(request.getPath(), body, request);
			
			body.println();
			body.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void redirect(Path path, PrintStream body, Request request) {
		String directory = path.getDirectory();
		
		switch(directory){
			case "medico": 
				handleMedico(path.getName(), body);
			case "paciente":
				handlePaciente(path.getName(), body, request);
			case "consulta":
				handleConsulta(path.getName(), body, request);
		}
	}

	private void handleConsulta(String method, PrintStream body, Request request) {
		switch(method) {
			case "save":
				Query q = request.getQuery();
				String paciente = q.get("paciente");
				String medico = q.get("medico");
				String data = q.get("data");
				String hora = q.get("hora");
				
				a.setConsulta(data, hora, paciente, medico);
			case "getAll":
				ArrayList<Consulta> consultas = a.getAllConsultas();
				
				JSONObject obj = new JSONObject(consultas);
				body.print(obj);
		}
	}

	private void handlePaciente(String method, PrintStream body, Request request) {
		switch(method) {
			case "save":
				Query q = request.getQuery();
				String historico = q.get("historico");
				String restricoes = q.get("restricoes");
				String nome = q.get("nome");
				String sexo = q.get("sexo");
				String email = q.get("email");
				String logradouro = q.get("logradouro");
				String cidade = q.get("cidade");
				String complemento = q.get("complemento");
				String celular = q.get("celular");
				String nascimento = q.get("nascimento");
				int cpf = Integer.parseInt(q.get("cpf"));
				int numero = Integer.parseInt(q.get("numero"));
				
				a.createPaciente(historico, restricoes, nome, sexo, email, logradouro, cidade,
						complemento, celular, nascimento, cpf, numero);
		}
	}

	private void handleMedico(String name, PrintStream body) {
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
