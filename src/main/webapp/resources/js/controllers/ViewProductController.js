angular.module('OnlineStoreApp.ViewProductController', [])
    .controller('ViewProductController', function ($scope, $http, $stateParams, $state) {


        $scope.review = {};

        var itemId = $stateParams.itemId;
        console.log(itemId, "Id");

        $http.post('restful-services/item/findItemById', itemId)
            .success(function (data, status) {
                if(status == 200){
                    $scope.item = data;
                    console.log($scope.item, "All items");
                }
            }).error(function (error) {
            alert("FIX ME!!!");
        });

        $scope.addItem = function (item) {
            console.log(item.item, "item displayed");

            let cartItem = {};
            cartItem.paid = false;
            cartItem.quantity = 1;
            let customer = {};
            customer.id = 1;
            cartItem.customer = customer;
            cartItem.item = item.item;


            $http.post('restful-services/cart/addCartItem', cartItem).then(function (response) {
                console.log(response);

                $state.go("basket", {
                    itemId: item.item.id
                });
            })
        };

        $scope.addComment = function () {

            console.log($scope.review, "reviewsFromForm");


            $http.post('restful-services/comment/addComment', JSON.stringify($scope.review))
                .success(function (data, status) {
                    if (status == 200) {
                        $scope.addComment = data;
                        console.log($scope.addComment, "Review added");
                    }
                }).error(function (error) {
                alert("FIX ME!!!");
            });
        };


    });