var polaflixApp = angular.module('PantallaPrincipal',[]);

polaflixApp.controller('polaflixController', function polaflixController($scope) {
    $scope.seriesEmpezadas =
      [ { 'name':'Prison Break'},
        { 'name':'Breaking bad'},
        { 'name':'lolololo'}
      ];

      console.log("I am breathing");
  
  });

//ire definiendo mas controladores... poner un controlador para el usuario y otro para las series, con eso es suficiente , y desde ahi accedo a todos sus elementos
//polaflixApp.controller(){}




