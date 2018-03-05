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
            <img class="card-img-top" src="` + entidade.imagem + `" alt="">
            <div class="card-body">
              <h2 class="card-title"> ` + entidade.titulo + ` </h2>
              <p class="card-text">` + entidade.descricao + `</p>
              <a href="#" class="btn btn-primary">Read More &rarr;</a>
            </div>
            <div class="card-footer text-muted">
              Posted  `+formatar(entidade.data)+`
              <a href="#">Start Bootstrap</a>
            </div>
          </div>		
          `;		
		$('#post-wrapper').append(html);
		
	}
}