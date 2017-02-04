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
	this.getListCompany = function(uri, search){
		return $http.get(uri + '/login/search-user-adm/' + search);
	};
	
	
}]);