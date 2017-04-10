angular.module('OnlineStoreApp.BasketController', [])
    .controller('BasketController', function ($scope, $http) {
        $scope.item ={};
        $scope.addCartItem = function () {

            console.log($scope.item, "itemsFromForm");


            $http.post('restful-services/cart/addCartItem', JSON.stringify($scope.item))
                .success(function (data, status) {
                    if (status == 200) {
                        $scope.addCartItem = data;
                        console.log($scope.addCartItem, "Cart Item added");
                    }
                }).error(function (error) {
                alert("FIX ME!!!");
            });
        }
    });

