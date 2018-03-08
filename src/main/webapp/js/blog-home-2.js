var cod = null;

$(document).ready(function(){
	buscarPosts();
	preparardatepicker();
});

function preparardatepicker(){
	$( function() {
	    $( "#datepicker" ).datepicker();
	    $( "#datepicker" ).on( "change", function() {
	    	$( "#datepicker" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
	    });
	  } );
}
function clicks() {
	$("#btn-inserir").click(
		function(){
			popularForm("", "", "", "", "");

			$("#modal-inc-alt").modal();
		}
	);	

	$(".deletaPost").click(
		function(){
			var entidade = $(this).parent().parent().parent().parent();

			cod = $(entidade).data("cod");
			titulo = $(entidade).data("titulo");

			$("#modal-excluir").modal();
			$("#post-titulo").html(titulo);
		}
	);

	$(".abrirModalPost").click(
		function(){
			var entidade = $(this).parent().parent().parent().parent();

			cod = $(entidade).data("cod");
			titulo = $(entidade).data("titulo");
			descricao = $(entidade).data("descricao");
			autor = $(entidade).data("autor");
			imagem = $(entidade).data("imagem");
			data = $(entidade).data("data");

			popularForm(titulo, descricao, autor, imagem, data);

			$("#modal-inc-alt").modal();
		}
	);
}

function formatar(data){
    // var currentdate = new Date(data); 
    // var locale = "pt-br";
    // var month = currentdate.toLocaleString(locale, { month: "long" });
    // var datetime = currentdate.getDate() + " de "
    //         + month  + " de " 
    //         + currentdate.getFullYear();  
   
           
    // return datetime;
    return data;
}

function buscarPosts() {
	$.ajax({
		url:'/post/rest/buscarTodos',
		complete: function (response) {
			var lista = response.responseJSON.objeto;
			addItensNaTela(lista);
			clicks();
		},
		error: function () {
			alert('Ixi: there was an error!');
		},
	});
}

function addItensNaTela(lista){


	for(var i = 0; i<lista.length; i++){
		var entidade = lista[i];
		var html = `
	      <div class="card mb-4"
	      	data-cod="`+ entidade.cod +`"
  			data-titulo="`+ entidade.titulo +`"
  			data-descricao="`+ entidade.descricao +`"
  			data-imagem="`+ entidade.imagem +`"
  			data-data="`+ entidade.data +`"
  			data-autor="`+ entidade.autor +`">
	        <div class="card-body">
	          <div class="row">
	            <div class="col-lg-6">
	              <a href="#">
	                <img class="img-fluid rounded" src="` + entidade.imagem + `" alt="">
	              </a>
	            </div>
	            <div class="col-lg-6">
	              <h2 class="card-title">` + entidade.titulo + `</h2>
	              <p class="card-text">` + entidade.descricao + `</p>
	              <a class="btn btn-danger deletaPost" >Apagar post</a>//metodo de delataPost
	              <a class="btn btn-success abrirModalPost" href="javascript:void(0)" >Editar post</a>
	            </div>
	          </div>
	        </div>
	        <div class="card-footer text-muted">
	         `+formatar(entidade.data) +` por
	          <a href="#">`+ entidade.autor +`</a>
	        </div>
	      </div>
		`;
		
		$('#post-wrapper').append(html);
		
	}
}

function deletarPost() {
	$.ajax({
		url:'/post/rest/deletar/' + cod,
		type: 'DELETE',
		complete: function (response) {
			console.log(response.responseJSON.mensagem);
			location.reload();
		},
		error: function () {
			alert('Não foi possivel deletar o post!!');
		},
	 
	});
}

function salvar() {
	var titulo = $("#titulo").val();
	var descricao = $("#descricao").val();
	var autor = $("#autor").val();
	var imagem = $("#imagem").val();
	var data = $("#datepicker").val();

	//atualizando
	var urlPreparada = '/post/rest/atualizar/';
	var typePreparado = 'PUT';
	
	if(isNaN(cod)){
		//criando
		urlPreparada = '/post/rest/criar/';
		typePreparado = 'POST';
	}

	$.ajax({
		url: urlPreparada,
		type: typePreparado,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
		    "cod": cod ,
		    "imagem": imagem ,
		    "titulo":  titulo ,
		    "descricao": descricao,
		    "data": data ,
		    "autor" : autor
		}),
		complete: function (response) {
			console.log(response.responseJSON.mensagem);
			location.reload();
		},
		error: function () {
			alert('Não foi possivel criar/atualizar o post!!');
		},
	 
	});
}

function popularForm(titulo, descricao, autor, imagem, data) {
	$("#titulo").val(titulo);
	$("#descricao").val(descricao);
	$("#autor").val(autor);
	$("#imagem").val(imagem);
	$("#datepicker").val(data);
}