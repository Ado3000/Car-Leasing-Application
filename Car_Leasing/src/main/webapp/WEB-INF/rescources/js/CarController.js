var CarController = function($scope, $http) {
    $scope.fetchCarsList = function() {
        $http.get('/cars/getList.json').success(function(getList){
            $scope.cars = getList;
        });
    };
    
    $scope.fetchCarsList();
};