kid.service('companyService', ['$http', 
                                function($http){
	
	/**
	 * Register Company
	 */
	this.getCompany = function(uri, companyDto){
		return $http.post(uri + '/company/register-company', companyDto);
	};
	
	/**
	 * List Company's
	 */
	this.getListCompany = function(uri, nameEstablishment, responsibleEstablishment,
			cnpj, objCity){
		return $http.get(uri + '/company/search-company/' + nameEstablishment + "/" + responsibleEstablishment + 
				"/" + cnpj + "/" + objCity);
	};
	
	/**
	 * inactive Company
	 */
	this.getInactiveCompany = function(uri, company){
		return $http.put(uri + '/company/inative-company', company);
	};
	
	/**
	 * Edit Company
	 */
	this.getEditCompany = function(uri, company){
		return $http.put(uri + '/company/edit-company', company);
	};
	
}]);