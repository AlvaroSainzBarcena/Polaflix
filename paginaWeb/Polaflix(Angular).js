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

  $http.get('http://localhost:8080//usuarios/' + user + '/seriesEmpezadas').
    then(function (response) {
      $scope.seriesEmpezadas = response.data;
    });
  $http.get('http://localhost:8080/usuarios/' + user + '/seriesPendientes').
    then(function (response) {
      $scope.seriesPendientes = response.data;
    });
  $http.get('http://localhost:8080/series'). // A modo de prueba, todas las series se mostraran como terminadas.
    then(function (response) {
      $scope.seriesTerminadas = response.data;
    });

  $scope.verSerieFun = function (serie) {

    serieSelec = serie;

  };

  // Metodo que comprueba si se ha modificado la variable serieSelec. En tal caso, actualiza su valor para que lo lea
  // el router VerSerie.html desde la variable de scope
  $scope.$watch('serieSelec', function () {
    $scope.serieSelec = serieSelec;
  });

});// fin controlador muestraSeriesPrincipal


polaflixApp.controller('controllerAgregarSerie', function ($scope, $http) {
  
  $scope.letras = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

  $http.get('http://localhost:8080/series').
    then(function (response) {
      $scope.series = response.data;
    });

  // funcion para mostrar las series con la inicial pasada por parametro
  $scope.muestraSeriesInicial = function (inicial) {

    $http.get('http://localhost:8080/series/inicial/' + inicial).
      then(function (response) {
        $scope.seriesInicial = response.data;
      });

    $scope.sinopsis = null;// para que se borre la sinopsis de la serie seleccionada enteriormente
  };

  //Funcion que asigna la sinopsis de la serie
  $scope.mostrarSinopsis = function (serie) {

    $scope.sinopsis = serie.sinopsis;

  }

  //Funcion que agrega la serie a la lista de pendietnes
  //TODO ¡¡ Preguntar a Pablo, me da error 500 internal server error al hacer la llamada POST!
  $scope.agregaPendientes = function (serie) {

    var idSerie = serie.id;

    $http.post('http://localhost:8080/usuarios/' + user + '/seriesPendientes/' + idSerie).
      then(function (response) {
        console.log(response);
      });
  };

  $scope.serieBuscada = "";

  //funcion que devuelve la lista de series cuya inicial coincide con la serie escrita
  $scope.submit = function () {

    var i;
    for (i = 0; i < $scope.series.length; i++) { // revisar el bucle, no devuelve las series
      if ($scope.series[i].nombreSerie.localeCompare($scope.serieBuscada)) {
        var inicial = $scope.serieBuscada.charAt(0);
        $http.get('http://localhost:8080/series/inicial/' + inicial).
          then(function (response) {
            $scope.seriesInicialBuscadas = response.data;
          });
      }
    }

  }


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
  serieSelec = null;
  return serieSelec;
});



//ire definiendo mas controladores... poner un controlador para el usuario y otro para las series, con eso es suficiente , y desde ahi accedo a todos sus elementos
//polaflixApp.controller(){}




