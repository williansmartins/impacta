function buscarDespesas() {
    $.ajax({
        url:'/despesas/todasDespesas',
        complete: function (response) {
            //$('#output').html(response.responseText);
        	var despesas = response.responseJSON;
        	addItensNaTabela(despesas);
        },
        error: function () {
            $('#output').html('Ixi: there was an error!');
        },
    });
    return false;
}

function addItensNaTabela(despesas){
	for(var i = 0; i<despesas.length; i++){
		var despesa = despesas[i];
		$('#tabela').append("<tr><td>"+despesa.codigo+"</td><td>"+despesa.categoria+"</td><td>"+despesa.descricao+"</td></tr>");
	}
}









