angular.module('OnlineStoreApp.BasketController', [])
    .controller('BasketController', function ($scope, $http, $stateParams, $state) {

        var itemId = $stateParams.itemId;

        $scope.item ={};

        $http.get('restful-services/cart/all').then(function (response) {
            $scope.allCartItems = response.data;
            console.log(response.data);
        });

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
        };

        $scope.completePurchase = function () {

            console.log($scope.item, "Purchase made");
            var payForThis = [];
            for(var i =0; i< $scope.allCartItems.length;i++){
                payForThis.push($scope.allCartItems[i].cartItem);
            }
            $http.post('restful-services/cart/purchaseAllCartItem', JSON.stringify(payForThis))
            .success(function (data, status) {
                if (status == 200) {
                    $scope.addCartItem = data;
                    console.log($scope.addCartItem, "Cart Items Purchased");
                }
            }).error(function (error) {
                alert("FIX ME!!!");

            });


            $state.go("items");
        }
    });

