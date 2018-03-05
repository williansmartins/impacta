$(document).ready(function(){
	buscarPosts();
});

function formatar(data){
    var currentdate = new Date(data); 
    var datetime = currentdate.getDate() + "/"
            + (currentdate.getMonth()+1)  + "/" 
            + currentdate.getFullYear()
            ;            
    return datetime;
}

function buscarPosts() {
	$.ajax({
		url:'/post/rest/buscarTodos',
		complete: function (response) {
			var lista = response.responseJSON.objeto;
			addItensNaTela(lista);
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
	              <a href="#" class="btn btn-primary">Read More &rarr;</a>
	            </div>
	          </div>
	        </div>
	        <div class="card-footer text-muted">
	        <a href="#"> Postado em Março </a>
	          <a class="data">(`+formatar(entidade.data)+` <a class="data_atual"></a>)
	          
	        </div>
	      </div>
		`;
		
		$('#post-wrapper').append(html);
		
	}
}