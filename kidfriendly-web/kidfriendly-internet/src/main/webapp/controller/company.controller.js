kid.controller('companyController', ['$scope', 'companyService', '$state', '$cookieStore', 'locationService', 'util', 
    function($scope, companyService, $state, $cookieStore, locationService, util){

	$scope.states = {};
	$scope.citys = {};
	$scope.companyDto = {};
	$scope.phoneDto = {};
	
	$scope.search = function(){
		$state.go('searchCompany');
	};
	
	$scope.back = function(){
		$state.go('company');
	};
	
	$scope.edit = function(){
		$state.go('editCompany');
	};
	
	/**
	 * Method loaded states in country Brazil
	 */
	locationService.getStates(util.getUri(), 1).success(function(data, status, headers, config) {
		$scope.states = data;
	}).error(function(data, status, headers, config) {
		
    });
	
	/**
	 * Method in selected state by loaded city
	 */
	$scope.getCityByState = function(objState){
		locationService.getCitys(util.getUri(), objState).success(function(data, status, headers, config) {
			$scope.citys = data;
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
	/**
	 * Method save company
	 */
	$scope.saveCompany = function(){
		console.log($scope.companyDto);
		companyService.getCompany(util.getUri(), $scope.companyDto).success(function(data, status, headers, config) {
			
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
}]);