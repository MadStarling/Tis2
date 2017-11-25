public class Consulta {

	String data, hora;
	int status;
	Paciente paciente;
	Medico medico;
	
	public Consulta(String data, String hora, int status, Paciente paciente, Medico medico) {
		this.data = data;
		this.hora = hora;
		this.status = status;
		this.paciente = paciente;
		this.medico = medico;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
		
}
