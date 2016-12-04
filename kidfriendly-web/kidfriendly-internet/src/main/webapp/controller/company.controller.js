kid.controller('companyController', ['$scope', 'loginService', '$state', '$cookieStore',
    function($scope, loginService, $state, $cookieStore){

	$scope.search = function(){
		$state.go('searchCompany');
	};
	
	$scope.back = function(){
		$state.go('company');
	};
	
	$scope.edit = function(){
		$state.go('editCompany');
	};
	
}]);