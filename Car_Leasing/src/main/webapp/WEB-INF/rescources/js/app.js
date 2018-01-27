var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngRoute','ngResource']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\view\layout.html',
        controller: CarController
    });
    
    $routeProvider.otherwise({redirectTo: '/'});
}]);	