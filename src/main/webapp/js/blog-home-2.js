var app = angular.module('myApp', []);

app.controller('postCtrl', function($scope, $http) {
    
    $http.get("/post/rest/buscarTodos")
    .then(function (response) {
    	$scope.lista = response.data.objeto;
    });
    
    $scope.deletar = function(cod){
    	$.ajax({
    		url:'/post/rest/deletar/' + cod,
    		type: 'DELETE',
    		complete: function (response) {
    			console.log(response.data.mensagem);
    		},
    		error: function () {
    			alert('Não foi possivel deletar o post!!');
    		},
    	 
    	});
    }
    
    
    
});