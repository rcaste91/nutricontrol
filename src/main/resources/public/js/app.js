var app = angular.module('nutriApp',['ngRoute']);

app.config(function($routeProvider) {
$routeProvider
 
.when('/', {
templateUrl : 'views/home.html',
controller : 'hController'
})
 
.when('/pacientes', {
templateUrl : 'views/paciente.html',
controller : 'fController'
})
 
.when('/comidas', {
templateUrl : 'views/comida.html',
controller : 'cController'
})

.when('/controles', {
templateUrl : 'views/control.html',
controller : 'coController'
})

.when('/controles/:id', {
templateUrl : 'views/control.html',
controller : 'coController'
})
 
.otherwise({redirectTo: '/'});
});
