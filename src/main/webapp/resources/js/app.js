angular.module('OnlineStoreApp',[
    'ngRoute',
    'ui.router',
    'OnlineStoreApp.LoginController',
    'OnlineStoreApp.ItemController',
    'OnlineStoreApp.AddItemController'

]).config(function ($stateProvider, $urlRouterProvider) {

    // $urlRouterProvider.otherwise("/account/login");
    $urlRouterProvider.otherwise("/item/addItem");


    $stateProvider
        .state('login',{
            url: "/account/login",
            templateUrl: "resources/js/views/login.html",
            controller: 'LoginController'
        })
        .state('items',{
            url: "/items/all",
            templateUrl:"resources/js/views/item.html",
            controller: 'ItemController'
        })
        .state('itemAdd',{
            url: "/item/add",
            templateUrl:"resources/js/views/addItem.html",
            controller: 'AddItemController'
        });

});