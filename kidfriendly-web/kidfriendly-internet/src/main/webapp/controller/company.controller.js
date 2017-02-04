kid.controller('companyController', ['$scope', 'companyService', '$state', '$cookieStore', 'locationService', 'util', 
    function($scope, companyService, $state, $cookieStore, locationService, util){

	$scope.states = {};
	$scope.citys = {};
	$scope.addressDto = {};
	$scope.companyDto = {};
	
	$scope.search = function(){
		$state.go('searchCompany');
	};
	
	$scope.back = function(){
		$state.go('company');
	};
	
	$scope.edit = function(){
		$state.go('editCompany');
	};
	
	locationService.getStates(util.getUri(), 1).success(function(data, status, headers, config) {
		$scope.states = data;
	}).error(function(data, status, headers, config) {
		
    });
	
	$scope.getCityByState = function(objState){
		locationService.getCitys(util.getUri(), objState).success(function(data, status, headers, config) {
			$scope.citys = data;
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
}]);