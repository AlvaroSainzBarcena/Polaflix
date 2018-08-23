var polaflixApp = angular.module("PantallaPrincipal",["ngRoute"]);

polaflixApp.controller('polaflixController', function polaflixController($scope) {
    $scope.seriesEmpezadas =
      [ { 'name':'Prison Break'},
        { 'name':'Breaking bad'},
        { 'name':'lolololo'}
      ];
  
  });

  // retorna el Usuario con nombre 'alvaro'
  polaflixApp.controller('Usuario', function($scope, $http) {
    $http.get('http://localhost:8080/usuarios/alvaro').
        then(function(response) {
            $scope.usuario = response.data;
        });
      });

  // ROUTING     
  polaflixApp.config(function($routeProvider) {
    $routeProvider
    .when("/", {
      templateUrl : "PantallaPrincipal.html"
    })
    .when("/PantallaPrincipal", {
      templateUrl : "PantallaPrincipal.html"
    })
    .when("/AgregarSerie", {
      templateUrl : "AgregarSerie.html"
    })
    .when("/VerCargos", {
      templateUrl : "VerCargos.html"
    })
    .when("/VerSerie", {
      templateUrl : "VerSerie.htm"
    });
  });

//ire definiendo mas controladores... poner un controlador para el usuario y otro para las series, con eso es suficiente , y desde ahi accedo a todos sus elementos
//polaflixApp.controller(){}




