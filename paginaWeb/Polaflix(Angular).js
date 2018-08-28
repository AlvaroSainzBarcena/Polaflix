var polaflixApp = angular.module("PantallaPrincipal", ["ngRoute"]);
var user = "alvaro";

// retorna el Usuario con nombre 'alvaro'
polaflixApp.controller('userController', function ($scope, $http) {
  $http.get('http://localhost:8080/usuarios/' + user + '').
    then(function (response) {
      $scope.usuario = response.data;
    });
});


polaflixApp.controller('muestraSeriesPrincipal', function ($scope, $http, servicioVerSerie) {

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

    $scope.verSerieFun = function(serie) {

      serieSelec=serie;

  };

  // Metodo que comprueba si se ha modificado la variable serieSelec. En tal caso, actualiza su valor para que lo lea
  // el router VerSerie.html desde la variable de scope
  $scope.$watch('serieSelec', function(){
    $scope.serieSelec=serieSelec;
  });

});// fin controlador muestraSeriesPrincipal


polaflixApp.controller('controllerAgregarSerie', function ($scope, $http) {

  $scope.letras=['A','B','C'];

  $http.get('http://localhost:8080/series').
    then(function (response) {
      $scope.series = response.data;
    });

    // funcion para mostrar las series con la inicial pasada por parametro
    $scope.muestraSeriesInicial = function(inicial) {

      $http.get('http://localhost:8080/series/inicial/'+inicial).
      then(function (response) {
        $scope.seriesInicial = response.data;
      });

  };
  

});//fin controllerAgregarSerie



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

 
// Servicio que inicializa y guarda en memoria la serie elegida en la ventana principal del usuario para pasarla
// al router verSerie
polaflixApp.factory('servicioVerSerie', function () {
  serieSelec=null;
  return serieSelec;
});



//ire definiendo mas controladores... poner un controlador para el usuario y otro para las series, con eso es suficiente , y desde ahi accedo a todos sus elementos
//polaflixApp.controller(){}




