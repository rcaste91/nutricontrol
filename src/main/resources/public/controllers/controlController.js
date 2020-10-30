app.controller('coController', function($scope, $http, $routeParams) {
	
	$scope.controles=[];
	$scope.pacientesS = [];
	$scope.pacId=$routeParams.id;
	
	$scope.busquedaNombre="";
	$scope.fechaHoy="";
	$scope.pacienteNombre="";
	$scope.pacientePlan="";
	
	$scope.pacienteEncontrado = false;
	$scope.pacienteUnControl = false;
	$scope.pacienteCargado = false;
	$scope.pacienteNoEnc = false;
	$scope.btnGuardar = false;
	
	 $scope.controlForm = {
        idControl: 0,
        idPaciente: 0,
        fechaControl: "",
        pesoTotal: 0,
        grasa: 0,
        agua: 0,
        masaMuscular: 0,
        edadMetabolica: 0,
        grasaVisc: 0,
        imc: 0,
        dx: 0,
        estomago: 0,
        cintura: 0,
        vientre: 0,
        pecho: 0,
        muslo: 0,
        brazo: 0,
        comentarios: "",
        observaciones: ""
    };
    
    $scope.calculo = {
        pesoTotal: "",
        grasa: "",
        agua: "",
        masaMuscular: "",
        edadMetabolica: "",
        grasaVisc: "",
        imc: "",
        dx: "",
        estomago: "",
        cintura: "",
        vientre: "",
        pecho: "",
        muslo: "",
        brazo: ""
    };
	
	if($scope.pacId != null){
		_cargarControles($scope.pacId);
	}
	
	
	$scope.buscarPac = function(){
		
		$scope.pacienteEncontrado = false;
		$scope.pacienteNoEnc = false;
		$scope.pacienteCargado = false;
		$scope.pacienteUnControl = false;
		$scope.btnGuardar = false;
		
		var empty = [];
		var method = 'GET'
		var url = 'api/v1/pacienteBusq';
		url = url + '?pac='+ $scope.busquedaNombre;
		
		$http({
            method: method,
            url: url,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function(res) { // success
                $scope.pacientesS = res.data;
                $scope.pacienteEncontrado = true;
                
                if($scope.pacientesS.length < 1){
                	$scope.pacienteNoEnc = true;
                }else{
                	$scope.pacienteNoEnc = false;
                }
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
	}
	
	///carga historial de controles de un paciente
	$scope.cargarPac = function(paciente){
	
		$scope.pacienteEncontrado = false;
		$scope.pacienteNoEnc = false;
		$scope.pacienteUnControl = false;
		$scope.pacienteCargado = true;
		$scope.btnGuardar = false;
		
		_cargarControles(paciente.idPaciente);
		
		$scope.pacienteNombre=paciente.nombre;
		$scope.pacientePlan=paciente.planNutricional;
		$scope.controlForm.idPaciente=paciente.idPaciente;
		
	
	}
	
	///guarda un control en BD
	$scope.guardarControl = function(){
	
		 $scope.controlForm.idControl = 0;
		 $scope.controlForm.fechaControl = new Date();
		 
		  $http({
            method: 'POST',
            url: 'api/v1/controles',
            data: angular.toJson($scope.controlForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
        
			function(res) { // success
            	alert("Control ingresado");
				$scope.pacienteUnControl = false;
				$scope.pacienteCargado = true;
				$scope.btnGuardar = false;
				_limpiar();
				
				_cargarControles($scope.controlForm.idPaciente)
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
			
			);
	
	}
	
	$scope.nuevoControl = function(){
	
		$scope.pacienteEncontrado = false;
		$scope.pacienteNoEnc = false;
		$scope.pacienteUnControl = true;
		$scope.btnGuardar = true;
		
		_limpiar();
		
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); 
		var yyyy = today.getFullYear();
	
		today = dd + '/' + mm + '/' + yyyy;
		
		$scope.fechaHoy=  today;
		
	}
	
	$scope.cancelar = function(){
	
		$scope.pacienteEncontrado = false;
		$scope.pacienteUnControl = false;
		$scope.pacienteCargado = true;
		$scope.pacienteNoEnc = false;
		$scope.btnGuardar = false;
		
		_limpiar();
	}
	
	$scope.cargarUnControl = function(control){
	
		$scope.pacienteEncontrado = false;
		$scope.pacienteNoEnc = false;
		$scope.pacienteUnControl = true;
		$scope.btnGuardar = false;
		
		$scope.fechaHoy=control.fechaControl;
		
		$scope.controlForm.idControl= control.idControl;
		
		$scope.controlForm.fechaControl= control.fechaControl;
		$scope.controlForm.pesoTotal= control.pesoTotal;
		$scope.controlForm.grasa= control.grasa;
		$scope.controlForm.agua= control.agua;
		$scope.controlForm.masaMuscular= control.masaMuscular;
		$scope.controlForm.edadMetabolica= control.edadMetabolica;
		$scope.controlForm.grasaVisc= control.grasaVisc;
		$scope.controlForm.imc= control.imc;
		$scope.controlForm.dx= control.dx;
		$scope.controlForm.estomago= control.estomago;
		$scope.controlForm.cintura= control.cintura;
		$scope.controlForm.vientre= control.vientre;
		$scope.controlForm.pecho= control.pecho;
		$scope.controlForm.muslo= control.muslo;
		$scope.controlForm.brazo= control.brazo;
		$scope.controlForm.comentarios= control.comentarios;
		$scope.controlForm.observaciones= control.observaciones;
		
		_cargarPrevDatos($scope.controlForm.idPaciente, $scope.controlForm.idControl)

	}
	
	function _cargarPrevDatos(pacId, contId){
	
	datosPrevios = [];
	
	 $http({
            method: 'GET',
            url: 'api/v1/controlp/?pac='+pacId+'&ctrl='+contId
        }).then(
            function(res) { // success
                datosPrevios = res.data;
                
                _calculoAnterior(datosPrevios);

            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
        
	}
	
	function _calculoAnterior(datosPrevios){
	
		if(datosPrevios.idControl == -1){
		
				$scope.calculo.pesoTotal= ""; 
        		$scope.calculo.grasa= "";
        		$scope.calculo.agua= "";
        		$scope.calculo.masaMuscular= "";
        		$scope.calculo.edadMetabolica= "";
        		$scope.calculo.grasaVisc= "";
        		$scope.calculo.imc= "";
        		$scope.calculo.dx= "";
        		$scope.calculo.estomago= "";
        		$scope.calculo.cintura= "";
        		$scope.calculo.vientre= "";
        		$scope.calculo.pecho= "";
        		$scope.calculo.muslo= "";
        		$scope.calculo.brazo="";
		}else{
				$scope.calculo.pesoTotal= $scope.controlForm.pesoTotal - datosPrevios.pesoTotal; 
        		$scope.calculo.grasa= $scope.controlForm.grasa - datosPrevios.grasa;
        		$scope.calculo.agua= $scope.controlForm.agua - datosPrevios.agua;
        		$scope.calculo.masaMuscular= $scope.controlForm.masaMuscular - datosPrevios.masaMuscular;
        		$scope.calculo.edadMetabolica= $scope.controlForm.edadMetabolica - datosPrevios.edadMetabolica;
        		$scope.calculo.grasaVisc= $scope.controlForm.grasaVisc - datosPrevios.grasaVisc;
        		$scope.calculo.imc= $scope.controlForm.imc - datosPrevios.imc;
        		$scope.calculo.dx= $scope.controlForm.dx - datosPrevios.dx;
        		$scope.calculo.estomago= $scope.controlForm.estomago - datosPrevios.estomago;
        		$scope.calculo.cintura= $scope.controlForm.cintura - datosPrevios.cintura;
        		$scope.calculo.vientre= $scope.controlForm.vientre - datosPrevios.vientre;
        		$scope.calculo.pecho= $scope.controlForm.pecho - datosPrevios.pecho;
        		$scope.calculo.muslo= $scope.controlForm.muslo - datosPrevios.muslo;
        		$scope.calculo.brazo=$scope.controlForm.brazo - datosPrevios.brazo;
        		
		}

	}
	
	function _cargarControles(pacId){
		
		 $http({
            method: 'GET',
            url: 'api/v1/controles/'+pacId
        }).then(
            function(res) { // success
                $scope.controles = res.data;
                $scope.controlForm.idPaciente= pacId;
                
                $scope.pacienteEncontrado = false;
				$scope.pacienteNoEnc = false;
				$scope.pacienteUnControl = false;
				$scope.pacienteCargado = true;
				$scope.btnGuardar = false;

            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
	
	}
	
	function _limpiar(){
	
		$scope.controlForm.idControl= 0;
		$scope.controlForm.fechaControl= "";
		//$scope.controlForm.idPaciente= 0;
		$scope.controlForm.pesoTotal= 0;
		$scope.controlForm.grasa= 0;
		$scope.controlForm.agua= 0;
		$scope.controlForm.masaMuscular= 0;
		$scope.controlForm.edadMetabolica= 0;
		$scope.controlForm.grasaVisc= 0;
		$scope.controlForm.imc= 0;
		$scope.controlForm.dx= 0;
		$scope.controlForm.estomago= 0;
		$scope.controlForm.cintura= 0;
		$scope.controlForm.vientre= 0;
		$scope.controlForm.pecho= 0;
		$scope.controlForm.muslo= 0;
		$scope.controlForm.brazo= 0;
		$scope.controlForm.comentarios= "";
		$scope.controlForm.observaciones= "";
		
		$scope.calculo.pesoTotal= ""; 
        		$scope.calculo.grasa= "";
        		$scope.calculo.agua= "";
        		$scope.calculo.masaMuscular= "";
        		$scope.calculo.edadMetabolica= "";
        		$scope.calculo.grasaVisc= "";
        		$scope.calculo.imc= "";
        		$scope.calculo.dx= "";
        		$scope.calculo.estomago= "";
        		$scope.calculo.cintura= "";
        		$scope.calculo.vientre= "";
        		$scope.calculo.pecho= "";
        		$scope.calculo.muslo= "";
        		$scope.calculo.brazo="";
	}
	

});