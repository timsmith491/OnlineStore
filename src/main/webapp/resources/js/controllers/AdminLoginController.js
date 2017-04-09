angular.module('OnlineStoreApp.AdminLoginController', [])
    .controller('AdminLoginController', function ($scope, $http, $state) {
        $scope.admin ={};

        $scope.addAdmin = function () {

            console.log($scope.admin, "adminFromForm");

            $http.post('restful-services/admin/addAdmin', JSON.stringify($scope.admin))
                .success(function (data, status) {
                    if (status == 200) {
                        $scope.admin = data;
                        console.log($scope.admin, "Added admin");
                        $state.go("items");
                    }
                }).error(function (error) {
                alert("FIX ME!!!");
            });
        }

        $scope.loginAdmin = function () {

            console.log($scope.admin, "loginAdminFromForm");

            $http.post('restful-services/admin/loginAdmin', JSON.stringify($scope.admin))
                .success(function (data, status) {
                    if (status == 200) {
                        $scope.admin = data;
                        console.log($scope.admin, "Logged in admin");
                        $state.go("items");
                    }
                }).error(function (error) {
                alert("FIX ME!!!");
            });
        }
    });


$(function() {

    $('#loginAdmin-form-link').click(function(e) {
        $("#loginAdmin-form").delay(100).fadeIn(100);
        $("#registerAdmin-form").fadeOut(100);
        $('#registerAdmin-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#registerAdmin-form-link').click(function(e) {
        $("#registerAdmin-form").delay(100).fadeIn(100);
        $("#loginAdmin-form").fadeOut(100);
        $('#loginAdmin-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});
