
function insertarUsuarios() {
	//console.log("entrando Ajx");
	
	var datosform = {nombre: $("#nombre").val(),
			apPaterno: $("#apellidop").val(),
			apMaterno: $("#apellidom").val(),
			edad: $("#edad").val(),
			usuario: $("#user").val(),
			password: $("#pass").val()};
	$.ajax({
		method: "POST",
		//?parameter=insert
		url: "../Usuarios?parameter=insert",
		dataType: "json",
		data: {info:JSON.stringify(datosform)}


	})
		
		.done(function(response) {
			//if (response != null){
			console.log(response);
		//	window.location.replace("../index.jsp");
			//}
			
		})
		.fail(function(err) {
			console.log("Negativo");
			console.log(err);

		});
		
	window.location.replace("../index.jsp");
}




function updateUsuarios() {
	//console.log("entrando Ajx");
	
	var datosform = {nombre: $("#txtNanme").val(),
			apPaterno: $("#txtAp").val(),
			apMaterno: $("#txtAm").val(),
			usuario: $("#txtUs").val(),
			password: $("#txtPass").val(),
			idPersona: $("#txtidper").val()};
	$.ajax({
		method: "POST",
		//?parameter=insert
		url: "Usuarios?parameter=update",
		dataType: "json",
		data: {infoup:JSON.stringify(datosform)}


	})
		
		.done(function(response) {
			//if (response != null){
			console.log(response);
		//	window.location.replace("../index.jsp");
			//}
			
		})
		.fail(function(err) {
			console.log("Negativo");
			console.log(err);

		});
		
	//window.location.replace("../index.jsp");
}