app.controller('fController', function($scope, $http) {

 	$scope.pacientes = [];
 	$scope.BuscPacientes = [];
 	$scope.mensajeBusqueda="";
 	$scope.pacFiltro="";
 	
    $scope.pacientesForm = {
        idPaciente: 0,
        nombre: "",
        planNutricional: "",
        correo: "",
        fechaNacimiento: ""
    };
    
    cargarPacienteData();
    
    function cargarPacienteData() {
        $http({
            method: 'GET',
            url: 'api/v1/pacientes'
        }).then(
            function(res) { // success
                $scope.pacientes = res.data;
                $scope.BuscPacientes = $scope.pacientes;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    
     $scope.crearPaciente = function() {
    
        var method = "";
        var url = "";

        if ($scope.pacientesForm.idPaciente == 0) {
            method = "POST";
            url = 'api/v1/pacientes';
        }else{
        	method = "PUT";
            url = 'api/v1/pacientes';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.pacientesForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
        
    };
    
    $scope.deletePaciente = function(paciente) {
        $http({
            method: 'DELETE',
            url: 'api/v1/pacientes/' + paciente.idPaciente
        }).then(_success, _error);
    };
    
    $scope.clearForm = function(){
    
    	$scope.pacientesForm = {
        idPaciente: 0,
        nombre: "",
        planNutricional: "",
        correo: "",
        fechaNacimiento: ""
    	};
    	
    }
    
    $scope.buscarPac = function(pacienteNombre) {
    	
    	arreglo=[];
    	counter=0;
    	$scope.BuscPacientes = $scope.pacientes;
    	$scope.mensajeBusqueda="";
    
    	$scope.BuscPacientes.forEach(pac => {
    	
    		if(pac.nombre.toLowerCase().includes(pacienteNombre.toLowerCase())){
    			arreglo[counter]=pac;
    			counter++;
    		}
    		
    	});
    	
    	if(arreglo.length > 0 ){
    		$scope.BuscPacientes = arreglo;
    	}else{
    		$scope.mensajeBusqueda="No se encontraron pacientes";
    	}
    	
    }
    
     $scope.seleccionar = function(paciente) {
    
    	$scope.pacientesForm.idPaciente = paciente.idPaciente;
    	$scope.pacientesForm.nombre = paciente.nombre;
    	$scope.pacientesForm.planNutricional = paciente.planNutricional;
    	$scope.pacientesForm.correo = paciente.correo;
    	
    	let fecha_prev =new Date(paciente.fechaNacimiento);
    	
    	let textDia=fecha_prev.getDate();
    	if(fecha_prev.getDate() < 10){
    	textDia="0"+textDia;
    	}
    	
    	let textMes=fecha_prev.getMonth();
    	textMes=textMes+1;
    	if(textMes < 10){
    	textMes="0"+ textMes;
    	}
    	
    	let fecha_nu = textDia + "-" + textMes + "-" + fecha_prev.getFullYear();
    	$scope.pacientesForm.fechaNacimiento = fecha_nu;
    	
    };
    
    
    function _clearForm(){
		$scope.pacientesForm = {
        idPaciente: 0,
        nombre: "",
        planNutricional: "",
        correo: "",
        fechaNacimiento: ""
    	};
    }
    
     function _success(res) {
     	_clearForm()
		cargarPacienteData();
        alert("Operacion exitosa ");
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

	$("#date").datepicker({
	  dateFormat: "dd-mm-yy",
	  dayNamesMin: [ "Do", "Lu", "Ma", "Mie", "Ju", "Vi", "Sa" ],
	  monthNames: [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ],
	  onSelect: function(dateText, inst){
	  		$scope.pacientesForm.fechaNacimiento = dateText;
	  	}
	});


});

