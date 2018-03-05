$(document).ready(function(){

	buscarDespesas();
	buscarProfessores();
	listarProfessores();

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
    


function listarProfessores() {
	$.ajax({
		url:'/professor/buscarTodos',
		complete: function (response) {
			var professores = response.responseJSON;
			listaProfessores(professores);
		},
		error: function () {
			$('#output').html('Ixi: there was an error!');
		},
	});
}




$(function() {

	$("#cad_professor").click(
			  function (){
					abrirLoading();
					$.ajax({
						enctype: 'multipart/form-data',
						type : 'POST',
						url:'/professor/criar',
						data : {
							nome : $("#nome").val(),
							salario : $("#salario").val(),
							data : $("#data").val(),

							cargo : $("#cargo").val(),
							cargo : $("#file").val(),
							
						},
					
						success : function(r) {
							fecharLoading();
							 window.location.href = "ListaProfessores.html";
						},
						error : function() {
							commit(false);
							alert('deu erro');
						  },
				    });
					
					
				});
});



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
	function listaProfessores(professores){
		for(var i = 0; i<professores.objeto.length; i++){
			var pro = professores.objeto[i];
			var total_salario=pro.salario;
			$('#tabela').append("<tr><td>"+pro.codigo+"</td><td>"+"<tr><td>"+pro.imagem+"</td><td>"+pro.nome+"</td><td>"+pro.cargo+"</td><td>"+pro.dataInicio+"</td><td>"+pro.salario+"</td><td><a href='#' class='btn btn-success'>editar</a>&nbsp;<a href='#' class='btn btn-danger'>excluir</a></td></tr>");
			

		}
		$('#total_professores').append(professores.objeto.length);
		$('#total_salario').append(total_salario);
	}




	function abrirLoading() {
		$(".loading").show();
		$("body").css("background-color","#9494b8");
	}

	function fecharLoading() {
		$(".loading").hide();
	}


