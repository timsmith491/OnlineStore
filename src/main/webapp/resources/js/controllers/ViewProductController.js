angular.module('OnlineStoreApp.ViewProductController', [])
    .controller('ViewProductController', function ($scope, $http, $stateParams, $state) {

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

            $state.go("basket", {
                itemId: item.item.id
            });
        }

    });