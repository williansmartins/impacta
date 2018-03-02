$(document).ready(buscarDespesas());

function buscarDespesas() {
	$.ajax({
		url:'/despesas/todasDespesas',
		complete: function (response) {
			var despesas = response.responseJSON;
			addItensNaTela(despesas);
		},
		error: function () {
			$('#output').html('Ixi: there was an error!');
		},
	});
}
    
function addItensNaTabela(despesas){
	for(var i = 0; i<despesas.length; i++){
		var despesa = despesas[i];
		$('#tabela').append("<tr><td>"+despesa.codigo+"</td><td>"+despesa.categoria+"</td><td>"+despesa.descricao+"</td><td>"+despesa.valor+"</td><td>"+despesa.data+"</td><td>"+despesa.observacoes+"</td><td><a href='#' class='btn btn-success'>editar</a>&nbsp;<a href='#' class='btn btn-danger'>excluir</a></td></tr>");
	}
}

function addItensNaTela(despesas){
	for(var i = 0; i<despesas.length; i++){
		var despesa = despesas[i];
		$('#cards').append("<div class='col-lg-4 mb-4'> <div class='card h-100'> <h4 class='card-header'>"+despesa.descricao+"</h4> <div class='card-body'> <p class='card-text'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p> </div> <div class='card-footer'> <a href='#' class='btn btn-primary'>Valor R$ </a>" +despesa.valor+ " </div> </div> </div>");
	}
}








