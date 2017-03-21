angular.module('OnlineStoreApp.LoginController', [])
    .controller('LoginController', function ($scope, $http) {
        $scope.name = "Tim";

        $http.get('restful-services/customer/all')
            .success(function (data, status) {
                if(status == 200){
                    $scope.allCustomers = data;
                    console.log($scope.allCustomers, "All my customers");
                }
            }).error(function (error) {
                alert("FIX ME!!!");
            });
    });
