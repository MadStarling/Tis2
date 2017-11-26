import java.util.ArrayList;
import java.util.Iterator;

public class Agenda {
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	ArrayList<Medico> medicos = new ArrayList<Medico>();
	
	public void createPaciente(String historico, String restricoes, String nome, String sexo, String email, String logradouro,
			String cidade, String complemento, String celular, String nascimento, String cpf){
			int id = 0;
			while (pacientes.iterator().hasNext()) {
				id++;
			}
			
			
			Paciente p = new Paciente(historico, restricoes, nome, sexo, email, logradouro, cidade,
					complemento, celular, nascimento, id+1, cpf);
			
			pacientes.add(p);
	}
	
	public void setConsulta(String data, String hora, String pacienteName, String medicoName) {
		Medico m = null;
		Paciente p = null;
		
		for(Paciente currentPaciente : pacientes) {
			if(currentPaciente.getNome() == pacienteName) {
				p = currentPaciente;
			}
		}
		
		for(Medico currentMedico : medicos) {
			if(currentMedico.getNome() == medicoName) {
				m = currentMedico;
			}
		}
		
		Consulta c = new Consulta(data, hora, 1, p, m);
		
		consultas.add(c);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Consulta> getAllConsultas() {
		return (ArrayList<Consulta>) consultas.clone();
	}
}
