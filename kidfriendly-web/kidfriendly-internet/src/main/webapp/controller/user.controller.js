kid.controller('userController', ['$scope', 'userService', '$state', '$cookieStore',
    function($scope, userService, $state, $cookieStore){

	$scope.search = function(){
		$state.go('searchAdm');
	};
	
	$scope.back = function(){
		$state.go('adm');
	};
	
	$scope.edit = function(){
		$state.go('editAdm');
	};
	
}]);