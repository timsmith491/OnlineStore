angular.module('OnlineStoreApp',[
    'ngRoute',
    'ui.router',
    'OnlineStoreApp.LoginController',
    'OnlineStoreApp.ItemController',
    'OnlineStoreApp.AddItemController',
    'OnlineStoreApp.ViewProductController'


]).config(function ($stateProvider, $urlRouterProvider) {

    // $urlRouterProvider.otherwise("/account/login");
    $urlRouterProvider.otherwise("/customer/add");


    $stateProvider
        .state('login',{
            url: "/customer/add",
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
        })
        .state('itemView',{
            url: "/item/view/:itemId",
            templateUrl:"resources/js/views/viewItem.html",
            controller: 'ViewProductController'
        });

});