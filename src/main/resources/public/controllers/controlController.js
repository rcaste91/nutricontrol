app.controller('coController', function($scope, $http, $routeParams) {
	
	$scope.controles=[];
	$scope.pacId=$routeParams.id;
	
	_cargarControles($scope.pacId);
	
	function _cargarControles(pacId){
		
		 $http({
            method: 'GET',
            url: 'api/v1/controles/'+pacId
        }).then(
            function(res) { // success
                $scope.controles = res.data;
                console.log("termino todo bien");
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
	
	}
	

});