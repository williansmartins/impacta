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
		var html = `
			<div class='col-lg-4 mb-4'>
			   <div class='card h-100'>
			      <h4 class='card-header'>`+despesa.descricao+ ` <a class="data">( `+despesa.data+ ` )</a>
			      	<span class='categoria ` + despesa.categoria.toLowerCase() + `'></span>
			      </h4>
			      <div class='card-body'>
			         <p class='card-text'>`+despesa.observacoes+` </p>
			      </div>
			      <div class='card-footer'> <a href='#' class='btn btn-primary'>R$`+despesa.valor+ `</a> </div> 
			   </div>
			</div>
		`;
		
		$('#cards').append(html);
		
	}
}








