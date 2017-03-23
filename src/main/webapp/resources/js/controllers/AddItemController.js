angular.module('OnlineStoreApp.AddItemController', [])
    .controller('AddItemController', function ($scope, $http) {
        $scope.item ={};

        $scope.addItem = function () {

            console.log($scope.item, "itemsFromForm");


            $http.post('restful-services/item/addItem', JSON.stringify($scope.item))
                .success(function (data, status) {
                    if (status == 200) {
                        $scope.addItem = data;
                        console.log($scope.addItem, "Item added");
                    }
                }).error(function (error) {
                alert("FIX ME!!!");
            });
        }
    });
