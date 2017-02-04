kid.service('companyService', ['$http', 
                                function($http){
	
	/**
	 * Register Company
	 */
	this.getCompany = function(uri, companyDto, city){
		return $http.post(uri + '/company/register-company', companyDto, city);
	};
	
	/**
	 * List Company's
	 */
	this.getListCompany = function(uri, search){
		return $http.get(uri + '/login/search-user-adm/' + search);
	};
	
	
}]);