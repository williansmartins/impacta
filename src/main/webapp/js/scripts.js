$(document).ready(buscarDespesas());

function buscarDespesas() {
	$.ajax({
		url:'/despesas/todasDespesas',
		complete: function (response) {
			var despesas = response.responseJSON;
			addItensNaTabela(despesas);
		},
		error: function () {
			$('#output').html('Ixi: there was an error!');
		},
	});
}
    
function addItensNaTabela(despesas){
	for(var i = 0; i<despesas.length; i++){
		var despesa = despesas[i];
		$('#tabela').append("<tr><td>"+despesa.codigo+"</td><td>"+despesa.categoria+"</td><td>"+despesa.descricao+"</td><td>"+despesa.valor+"</td><td>"+despesa.data+"</td><td>"+despesa.observacoes+"</td></tr>");
	}
}








