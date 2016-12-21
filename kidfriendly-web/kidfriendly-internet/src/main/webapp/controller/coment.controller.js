kid.controller('comentController', ['$scope', 'comentService', '$state', '$cookieStore', 'util',
    function($scope, comentService, $state, $cookieStore, util){

	$scope.coments = {};
	$scope.messages = {};
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
	 * Method show data list
	 */
	comentService.getRating(util.getUri()).success(function(data, status, headers, config) {
		$scope.coments = data;
	}).error(function(data, status, headers, config) {
		
    });
	
	/**
	 * Method activate rating
	 */
	$scope.active = function(id){
		comentService.getActive(util.getUri(), id).success(function(data, status, headers, config) {
			comentService.getRating(util.getUri()).success(function(response, s, h, c) {
				$scope.coments = response;
				$scope.messages = "Ativado com sucesso...";
				$scope.visibleMessage = true;
			}).error(function(data, status, headers, config) {
				
		    });
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
	$scope.deleteRating = function(id){
		comentService.getActiveNotShow(util.getUri(), id).success(function(data, status, headers, config) {
			comentService.getRating(util.getUri()).success(function(response, s, h, c) {
				$scope.coments = response;
				$scope.messages = "Desativado com sucesso...";
				$scope.visibleMessage = true;
			}).error(function(data, status, headers, config) {
				
		    });
		}).error(function(data, status, headers, config) {
			
	    });
	};
	
}]);