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
	$(".deletaPost").click(
		function(){
			id = $(this).data("id");
			var titulo = $(this).data("titulo");
			$("#Modal-excluir").modal();
			$("#post-titulo").html(titulo);
			
			
		}
	);
}

function formatar(data){
    var currentdate = new Date(data); 
    var locale = "pt-br";
    var month = currentdate.toLocaleString(locale, { month: "long" });
    var datetime = currentdate.getDate() + " de "
            + month  + " de " 
            + currentdate.getFullYear();  
   
           
    return datetime;
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
	      <div class="card mb-4">
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
	              <p class="card-text">` +  entidade.data +`</p>
	              <a class="btn btn-danger deletaPost" href="javascript:void(0)" data-id="`+ entidade.cod +`" data-titulo="`+ entidade.titulo +`">Apagar post</a>
	             
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
		url:'/post/rest/deletar/' + id,
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


	$.ajax({
		url:'/post/rest/criar/',
		type: 'POST',
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify({
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
			alert('Não foi possivel criar o post!!');
		},
	 
	});
}

function popularForm() {
	$("#titulo").val("#titulo");
	$("#descricao").val("#descricao");
	$("#autor").val("#autor");
	$("#imagem").val("#imagem");
	$("#data").val("#data");
}