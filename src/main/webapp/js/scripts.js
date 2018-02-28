$(document).ready(buscarDespesas());

function buscarDespesas() {
	
    $.ajax({
        url:'/despesas/todasDespesas',
        complete: function (response) {
<<<<<<< HEAD
         //   $('#output').html(response.responseText);
            var despesas = response.responseJSON;
            addItensNaTabela(despesas);
=======
            //$('#output').html(response.responseText);
        	var despesas = response.responseJSON;
        	addItensNaTabela(despesas);
>>>>>>> 03f92fb5ec5cfe80329f14e54798bb19fe550f46
        },
        error: function () {
            $('#output').html('Ixi: there was an error!');
        },
    });
    return false;
<<<<<<< HEAD
    
    function addItensNaTabela(despesas){
    	    	
    	for (var i = 0 ; i<despesas.length; i++ ){
    		
    	var despesa = despesas[i];
    	$('tabela').append("<tr><td>+despesa.codigo+</td><td>+despesa.Categoria+</td><td>+despesa.data+</td></tr>");
    }
  }
}
=======
}

function addItensNaTabela(despesas){
	for(var i = 0; i<despesas.length; i++){
		var despesa = despesas[i];
		$('#tabela').append("<tr><td>"+despesa.codigo+"</td><td>"+despesa.categoria+"</td><td>"+despesa.descricao+"</td><td>"+despesa.valor+"</td></tr>");
	}
}









>>>>>>> 03f92fb5ec5cfe80329f14e54798bb19fe550f46
