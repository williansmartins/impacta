$(document).ready(function(){

	buscarDespesas();
	buscarProfessores();

	$( "#buscar" ).click(function() {
	  	alert(123);
	});
});

function GetNow(){
    var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
            + (currentdate.getMonth()+1)  + "-" 
            + currentdate.getFullYear() + " "  
            + currentdate.getHours() + ":"  
            + currentdate.getMinutes() + ":" 
            + currentdate.getSeconds();
    return datetime;
}

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



function buscarProfessores() {
	$.ajax({
		url:'/professor/buscarTodos',
		complete: function (response) {
			var professores = response.responseJSON;
			addProfessoresNaTela(professores);
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
			      <h4 class='card-header'>`+despesa.descricao+ `
			      	<span class='categoria ` + despesa.categoria.toLowerCase() + `'></span>
			      </h4>
			      <div class='card-body'>
			         <p class='card-text'>`+despesa.observacoes + "--" + GetNow() + `</p>
			      </div>
			      <div class='card-footer'> <a href='#' class='btn btn-primary'>R$ ` +despesa.valor+ `</a></div>
			   </div>
			</div>
		`;
		
		$('#cards').append(html);
		
	}
}


function addProfessoresNaTela(professores){
	for(var i = 0; i<professores.objeto.length; i++){
		var pro = professores.objeto[i];
		$('#prof').append("<div class='col-lg-4 col-sm-6 portfolio-item'> <div class='card h-100'><a href='#'><img class='card-img-top' src='http://placehold.it/700x400' alt=''></a> <div class='card-body'><h4 class='card-title'><a href='#'>"+pro.nome+"</a></h4>  <p class='card-text'>"+pro.cargo+"</p></div></div> </div>");
	}
}







