kid.controller('companyController', ['$scope', 'companyService', '$state', '$cookieStore', 'locationService', 'util', '$timeout', 'ngProgressFactory',
    function($scope, companyService, $state, $cookieStore, locationService, util, $timeout, ngProgressFactory){

	$scope.states = {};
	$scope.citys = {};
	$scope.companyDto = {};
	$scope.phoneDto = {};
	$scope.companyDto.phoneDtos = [];
	$scope.messages = "";
	$scope.cssMessage = "";
	$scope.visibleMessage = false;
	$scope.companys = {};
	$scope.company = {};
	
	$scope.progressbar = ngProgressFactory.createInstance();
	
	$scope.initEdit = function(){
		if($scope.company.idCompany == undefined || $scope.company.idCompany == null){
			$scope.company = $cookieStore.get("company");
		}
	};
	
	var searching = function() {
		$state.go('searchCompany');
    };
	
	$scope.search = function(){
		$state.go('searchCompany');
	};
	
	$scope.back = function(){
		$state.go('company');
	};
	
	$scope.edit = function(company){
		console.log(company);
		$cookieStore.put("company", company);
		$state.go('editCompany');
	};
	
	/**
	 * Method loaded states in country Brazil
	 */
	//locationService.getStates(util.getUri(), 2).success(function(data, status, headers, config) {
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
		$scope.progressbar.start();
		$timeout($scope.progressbar.complete(), 10000);
		$scope.progressbar.set(100);
		$scope.companyDto.phoneDtos = [];
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
	$scope.searchCompany = function(nameEstablishment, responsibleEstablishment,
			cnpj, objCity){
		companyService.getListCompany(util.getUri(), nameEstablishment, responsibleEstablishment,
				cnpj, objCity).success(function(data, status, headers, config) {
			$scope.companys = data;
			if($scope.companys == null){
				$scope.messages = "Não trouxe nenhum dado referente aos filtros selecionados.";
				$scope.visibleMessage = true;
				$scope.cssMessage = "message-table-incorret";
			}
		}).error(function(data, status, headers, config) {
			$scope.messages = "Error: não foi processado...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-incorret";
	    });
	};
	
	/**
	 * Method in inative company
	 */
	$scope.inactiveCompany = function(company){
		companyService.getInactiveCompany(util.getUri(), company).success(function(data, status, headers, config) {
			if(data == null){
				$scope.messages = "O estabeecimento permanece ativo por algum erro interno no sistema.";
				$scope.visibleMessage = true;
				$scope.cssMessage = "message-table-incorret";
			}else{
				companyService.getListCompany(util.getUri(), $scope.nameEstablishment, $scope.responsibleEstablishment,
						$scope.cnpj, $scope.objCity).success(function(data, status, headers, config) {
					$scope.companys = data;
					if($scope.companys == null){
						$scope.messages = "Não trouxe nenhum dado referente aos filtros selecionados.";
						$scope.visibleMessage = true;
						$scope.cssMessage = "message-table-incorret";
					}
				}).error(function(data, status, headers, config) {
					$scope.messages = "Error: não foi processado...";
					$scope.visibleMessage = true;
					$scope.cssMessage = "message-table-incorret";
			    });
			}
		}).error(function(data, status, headers, config) {
			$scope.messages = "Error: não foi processado...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-incorret";
	    });
	};
	
	$scope.editCompany = function(){
		$scope.progressbar.start();
		$timeout($scope.progressbar.complete(), 10000);
		$scope.progressbar.set(100);
		companyService.getEditCompany(util.getUri(), $scope.company).success(function(data, status, headers, config) {
			if(data == null){
				$scope.messages = "O estabeecimento não pode ser alterado.";
				$scope.visibleMessage = true;
				$scope.cssMessage = "message-table-incorret";
			}
			$scope.messages = "Alterado com sucesso...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-correct";
			$timeout(searching, 2000);
		}).error(function(data, status, headers, config) {
			$scope.messages = "Error: não foi processado...";
			$scope.visibleMessage = true;
			$scope.cssMessage = "message-table-incorret";
	    });
	};
	
}]);