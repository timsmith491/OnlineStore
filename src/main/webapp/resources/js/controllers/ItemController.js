angular.module('OnlineStoreApp.ItemController', [])
    .controller('ItemController', function ($scope, $http, $state) {

        $http.get('restful-services/item/all')
            .success(function (data, status) {
                if(status == 200){
                    $scope.allItems = data;
                    console.log($scope.allItems, "All items");
                }
            }).error(function (error) {
            alert("FIX ME!!!");
        });

        $scope.details= function (item) {
            console.log(item.item, "item displayed");
            console.log(JSON.stringify(item.item.id));

            $state.go("itemView", {
                itemId:item.item.id
            });
        }
    });
