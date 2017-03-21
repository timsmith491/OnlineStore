angular.module('OnlineStoreApp',[
    'ngRoute',
    'ui.router',
    'OnlineStoreApp.LoginController'
]).config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/account/login");

    $stateProvider
        .state('login',{
            url: "/account/login",
            templateUrl: "resources/js/views/login.html",
            controller: 'LoginController'
        });

});