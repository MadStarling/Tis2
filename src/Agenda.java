import java.util.ArrayList;
import java.util.Iterator;

public class Agenda {
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	ArrayList<Medico> medicos = new ArrayList<Medico>();
	
	public void createPaciente(String historico, String restricoes, String nome, String sexo, String email, String logradouro,
			String cidade, String complemento, String celular, String nascimento, int cpf, int numero){
			int id = 0;
			while (pacientes.iterator().hasNext()) {
				id++;
			}
			
			
			Paciente p = new Paciente(historico, restricoes, nome, sexo, email, logradouro, cidade,
					complemento, celular, nascimento, id+1, cpf, numero);
			
			pacientes.add(p);
	}
	
	public void setConsulta(String data, String hora, String pacienteName, String medicoName) {
		Medico m = null;
		Paciente p = null;
		
		Iterator<Paciente> i = pacientes.iterator();
		
		while(i.hasNext()) {
			if(i.next().getNome() == pacienteName) {
				p = (Paciente) i.next();
			}
		}
		
		Iterator<Medico> j = medicos.iterator();
		
		while(j.hasNext()) {
			if(j.next().getNome() == pacienteName) {
				m = (Medico) j.next();
			}
		}
		
		Consulta c = new Consulta(data, hora, 1, p, m);
		
		consultas.add(c);
	}
}
