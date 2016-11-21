/**
 * Created by Paulo on 24/11/2015.
 */
var kid = angular.module('kid',['ui.bootstrap', 'ngResource', 'ngRoute', 'ngCookies', 'ui.router']);

kid.config(['$stateProvider', '$urlRouterProvider', '$routeProvider', function($stateProvider, $urlRouterProvider, $routeProvider) {
	 
	var urlUnidade = 'http://' + window.location.host + '/hlc';
	
	$stateProvider.state('/', {
	   url: '/',
	   templateUrl : 'pages/login/login.html',
	   controller     : 'loginController',
	});
	
   $urlRouterProvider.otherwise('/');
}]);