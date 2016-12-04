kid.controller('loginController', ['$scope', 'loginService', '$state', '$cookieStore',
    function($scope, loginService, $state, $cookieStore){

	$scope.login = function(){
		$state.go('initial');
	};
	
}]);