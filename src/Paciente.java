public class Paciente {
	private String historico, restricoes, nome, sexo, email, logradouro, cidade, complemento, celular, nascimento;
	private int id, cpf, numero;
	
	public Paciente() {
		super();
	}
	public Paciente(String historico, String restricoes, String nome, String sexo, String email, String logradouro,
			String cidade, String complemento, String celular, String nascimento, int id, int cpf, int numero) {
		super();
		this.historico = historico;
		this.restricoes = restricoes;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.celular = celular;
		this.nascimento = nascimento;
		this.id = id;
		this.cpf = cpf;
		this.numero = numero;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getRestricoes() {
		return restricoes;
	}
	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
