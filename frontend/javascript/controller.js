var baseUrl = "http://127.0.0.1:880/";

function createPaciente() {

	var paciente = {
		nome: $('#nome').val(),
		email: $('#nascimento').val(),
		cpf: $('#cpf').val(),
		sexo: $('#sexo').val(),
		logradouro: $('#endereco').val(),
		cidade: $('#cidade').val(),
		complemento: $('#complemento').val(),
		tel: $('#tel').val(),
		historico: $('#doencas').val(),
		restricoes: $('#alergias').val()
	};
	var currentUrl = baseUrl + "paciente/save";
	
	$.ajax({
		url: currentUrl,
        type: 'POST',
        data: { json: JSON.stringify(paciente)},
        dataType: 'json'
	});
}

function agendar() {
	var dados = {
		medico: $('#medico').val(),
		paciente: $('#paciente').val(),
		data: $('#data').val(),
		hora: $('#hora').val()
	};

	var http = new XMLHttpRequest();
	var url = "http://127.0.0.1:880/consulta/save";
	http.open("POST", url, true);

	http.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	http.onreadystatechange = function() {
	    if(http.readyState == 4 && http.status == 200) {
	        alert('Paciente cadastrado com sucesso!');
	    }
	}
	http.send(paciente);
};