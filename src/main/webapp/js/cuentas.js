
function insertCuenta() {
	var datosform = {
		noCuenta: $("#txtcnta").val(),
		saldo: $("#txtsaldo").val(),
		moneda: $("#txtmoneda").val(),
		tipoCuenta: $("#txttipo").val(),
		idCliente: $("#idclnt").val()
	};
	$.ajax({
		method: "POST",
		url: "Cuentas?parameter=insert",
		dataType: "json",
		data: { datos: JSON.stringify(datosform) }

	})
		.done(function(response) {
			console.log(response);
			//window.location.replace("welcome.jsp");
			if (response != '') {
				$("#txtcnta").val("");
				$("#txtsaldo").val("");
				$("#txtmoneda").val("");
				$("#txttipo").val("");
				$("#idclnt").val("");
			}
		})
		.fail(function(err) {
			console.log(err);

		});
}


function retiro() {
	var datosform = {
		idCuentafk: $("#txtid").val(),
		noCuenta: $("#txtcnta").val(),
		monto: $("#txtmonto").val(),
		saldo: $("#txtsaldo").val(),
		monedatran: $("#txtmonedatran").val(),
		monedacnta: $("#txtmoneda").val(),
		tipocnta: $("#txttipo").val(),
		tipoMovimiento: "Retiro",
	};
	$.ajax({
		method: "POST",
		url: "Cuentas?parameter=retiro",
		dataType: "json",
		data: { movretiro: JSON.stringify(datosform) }

	})
		.done(function(response) {
			console.log(response);
			//window.location.replace("welcome.jsp");
		})
		.fail(function(err) {
			console.log(err);

		});
}



function deposito() {
	var datosform = {
		idCuentafk: $("#txtid").val(),
		noCuenta: $("#txtcnta").val(),
		monto: $("#txtmonto").val(),
		saldo: $("#txtsaldo").val(),
		monedatran: $("#txtmonedatran").val(),
		monedacnta: $("#txtmoneda").val(),
		tipocnta: $("#txttipo").val(),
		tipoMovimiento: "Deposito",
	};
	$.ajax({
		method: "POST",
		url: "Cuentas?parameter=deposito",
		dataType: "json",
		data: { movretiro: JSON.stringify(datosform) }

	})
		.done(function(response) {
			console.log(response);
			//window.location.replace("welcome.jsp");
		})
		.fail(function(err) {
			console.log(err);

		});
}



