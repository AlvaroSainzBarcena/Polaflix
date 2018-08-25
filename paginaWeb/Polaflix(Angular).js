var polaflixApp = angular.module("PantallaPrincipal", ["ngRoute"]);
var user = "alvaro";

// retorna el Usuario con nombre 'alvaro'
polaflixApp.controller('userController', function ($scope, $http) {
  $http.get('http://localhost:8080/usuarios/' + user + '').
    then(function (response) {
      $scope.usuario = response.data;
    });
});


polaflixApp.controller('muestraSeriesPrincipal', function ($scope, $http) {
  $http.get('http://localhost:8080/series').
    then(function (response) {
      $scope.seriesEmpezadas = response.data;
    });
  $http.get('http://localhost:8080/usuarios/' + user + '/seriesPendientes').
    then(function (response) {
      $scope.seriesPendientes = response.data;
    });
  $http.get('http://localhost:8080/usuarios/' + user + '/seriesTerminadas').
    then(function (response) {
      $scope.seriesTerminadas = response.data;
    });

    $scope.verSerieFun = function(serieSeleccionada) {
      $scope.serieSelec=serieSeleccionada;
  };

});


// ROUTING     
polaflixApp.config(function ($routeProvider) {
  $routeProvider
    .when("/", {
      templateUrl: "PantallaPrincipal.html"
    })
    .when("/PantallaPrincipal", {
      templateUrl: "PantallaPrincipal.html"
    })
    .when("/AgregarSerie", {
      templateUrl: "AgregarSerie.html"
    })
    .when("/VerCargos", {
      templateUrl: "VerCargos.html"
    })
    .when("/VerSerie", {
      templateUrl: "VerSerie.html"
    });
});

//ire definiendo mas controladores... poner un controlador para el usuario y otro para las series, con eso es suficiente , y desde ahi accedo a todos sus elementos
//polaflixApp.controller(){}




