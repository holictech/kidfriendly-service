kid.service('userService', ['$http', 
                                function($http){
	/**
	 * Method get data user adm
	 */
	this.getUserAdm = function(uri){
		return $http.get(uri + '/login/search-user-adm');
	};
	
	this.getAlterUser = function(uri, loginDto){
		return $http.put(uri + '/login/update-user-adm', loginDto);
	};
	
}]);