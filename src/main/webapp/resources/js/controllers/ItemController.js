angular.module('OnlineStoreApp.ItemController', [])
    .controller('ItemController', function ($scope, $http) {

        $http.get('restful-services/item/all')
            .success(function (data, status) {
                if(status == 200){
                    $scope.allItems = data;
                    console.log($scope.allItems, "All items");
                }
            }).error(function (error) {
            alert("FIX ME!!!");
        });
    });
