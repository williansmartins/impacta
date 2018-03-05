$(document).ready(function(){
	buscarPosts();
});

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
            <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
            <div class="card-body">
              <h2 class="card-title">` + entidade.titulo + `</h2>
              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!</p>
              <a href="#" class="btn btn-primary">Read More &rarr;</a>
            </div>
            <div class="card-footer text-muted">
              Posted on January 1, 2017 by
              <a href="#">Start Bootstrap</a>
            </div>
          </div>
		`;
		
		$('#post-wrapper').append(html);
		
	}
}