kid.controller('companyController', ['$scope', 'companyService', '$state', '$cookieStore', 'locationService', 'util', 
    function($scope, companyService, $state, $cookieStore, locationService, util){

	$scope.states = {};
	$scope.citys = {};
	$scope.companyDto = {};
	$scope.phoneDto = {};
	$scope.companyDto.phoneDtos = [];
	$scope.messages = "";
	$scope.cssMessage = "";
	$scope.visibleMessage = false;
	
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
	$scope.saveCompany = function(numPhone, cellPhone){
		$scope.phoneDto.numPhone = numPhone;
		$scope.companyDto.phoneDtos.push($scope.phoneDto);
		$scope.phoneDto.numPhone = cellPhone;
		$scope.companyDto.phoneDtos.push($scope.phoneDto);
		console.log($scope.companyDto);
		companyService.getCompany(util.getUri(), $scope.companyDto).success(function(data, status, headers, config) {
			$scope.messages = "Cadastrado com sucesso...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-correct";
			$scope.states = {};
			$scope.citys = {};
			$scope.companyDto = {};
			$scope.phoneDto = {};
			$scope.companyDto.phoneDtos = [];
			$scope.phoneFixed = "";
			$scope.celPhone = "";
		}).error(function(data, status, headers, config) {
			$scope.messages = "Error: não foi processado...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-incorret";
	    });
	};
	
	/**
	 * Method search company
	 */
	$scope.searchCompany = function(){
		companyService.getCitys(util.getUri(), objState).success(function(data, status, headers, config) {
			$scope.citys = data;
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
}]);