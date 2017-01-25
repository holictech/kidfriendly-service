kid.controller('userController', ['$scope', 'userService', '$state', '$cookieStore', 'util', 'ModalService', 
    function($scope, userService, $state, $cookieStore, util, ModalService){

	$scope.users = {};
	$scope.messages = "";
	$scope.cssMessage = "";
	$scope.visibleMessage = false;
	
	$scope.search = function(){
		$state.go('searchAdm');
	};
	
	$scope.back = function(){
		$state.go('adm');
	};
	
	$scope.edit = function(){
		$state.go('editAdm');
	};
	
	$scope.register = function(){
		$state.go('registerUser');
	};
	
	
	
	userService.getUserAdm(util.getUri()).success(function(data, status, headers, config) {
		$scope.users = data;
	}).error(function(data, status, headers, config) {
		$scope.messages = "Não foi possível carregar os dados dos usuários por algum erro interno...";
		$scope.visibleMessage = true;
		$scope.cssMessage = "message-table-incorret";
    });
	
}]);