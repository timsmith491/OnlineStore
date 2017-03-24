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




$(function() {

    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});
