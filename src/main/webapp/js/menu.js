

function cargarsession() {
	$("#container").load("views/iniciosession.jsp");
}



function cargafaddcnt() {
	$("#container").load("views/addcuenta.jsp");

}



function cargaraccs() {
	$("#txtoculto").hide();
	$("#container").load("views/mostraraccs.jsp");
	var id = { idCliente: $("#idusuario").val() };
	$.ajax({
		type: "POST",
		url: "Cuentas?parameter=all",
		dataType: "JSON",
		data: { infoid: JSON.stringify(id) },

	})
		.done(function(response) {
			console.log(response);
			response.forEach(e => console.log(e.idCuenta));

			var contenido;

			for (i = 0; i < response.length; i++) {
				contenido = contenido + "<tr><td>" + response[i].noCuenta +
					"</td><td>" + response[i].saldo +
					"</td><td>" + response[i].moneda +
					"</td><td>" + response[i].tipoCuenta
				"</td></tr>"
			}
			$("tbody").html(contenido);
			$("table").show();

		})
		.fail(function(err) {
			console.log(err);
		});
}



function cargartransac() {

	$("#container").load("views/transacciones.jsp");
	var id = { idCliente: $("#idusuario").val() };
	$.ajax({
		type: "POST",
		url: "Cuentas?parameter=all",
		dataType: "JSON",
		data: { infoid: JSON.stringify(id) },

	})
		.done(function(response) {
			console.log(response);
			response.forEach(e => console.log(e.noCuenta));

			$("#accounts").append('');


			for (i = 0; i < response.length; i++) {
				$("#accounts").append('<option value ="' + response[i].noCuenta + '" id="txtnobusq" >' + response[i].noCuenta + '</option>');
			}

			$("#accounts").change(function() {
				if ($(this).val() != '') {

					for (i = 0; i < response.length; i++) {
						if ($(this).val() == response[i].noCuenta) {
							$("#txtid").val(response[i].idCuenta);
							$("#txtcnta").val(response[i].noCuenta);
							$("#txtsaldo").val(response[i].saldo);
							$("#txtmoneda").val(response[i].moneda);
							$("#txttipo").val(response[i].tipoCuenta);
						}
					}

				} else {
					$("#txtcnta").val("");
					$("#txtsaldo").val("");
					$("#txtmoneda").val("");
					$("#txttipo").val("");

				}


			});

		})
		.fail(function(err) {
			console.log(err);
		});
}



/*
function cargarmovs() {
	$("#container").load("views/mostrarmovs.jsp");
	var id = { idCliente: $("#idusuario").val() };
	$.ajax({
		type: "POST",
		url: "Movimientos",
		dataType: "JSON",
		data: { infoid: JSON.stringify(id) },

	})
		.done(function(response) {
			console.log(response);
			response.forEach(e => console.log(e.noCuenta));

			$("#movs").append('');


			for (i = 0; i < response.length; i++) {
				$("#movs").append('<option value ="' + response[i].noCuenta + '"  >' + response[i].noCuenta + '</option>');
			}

			$("#movs").change(function() {
				if ($(this).val() != '') {

					var contenido;
					if ($(this).val() == response[i].noCuenta) {
						for (i = 0; i < response.length; i++) {
							contenido = contenido + "<tr><td>" + response[i].tipoMovimiento +
								"</td><td>" + response[i].moneda +
								"</td><td>" + response[i].monto +
								"</td><td>" + response[i].saldo
							"</td></tr>"
						}
					}
					$("tbody").html(contenido);
					$("table").show();
				}
			});

		})
		.fail(function(err) {
			console.log(err);
		});

}

*/


function cargarmovs() {
	$("#container").load("views/mostrarmovs.jsp");
	var id = { idCliente: $("#idusuario").val() };
	$.ajax({
		type: "POST",
		url: "Movimientos",
		dataType: "JSON",
		data: { infoid: JSON.stringify(id) },

	})
		.done(function(response) {
			console.log(response);
			response.forEach(e => console.log(e.noCuenta));

			var contenido;
			for (i = 0; i < response.length; i++) {
				contenido = contenido + "<tr><td>" + response[i].noCuenta +
					"</td><td>" + response[i].tipoMovimiento +
					"</td><td>" + response[i].monedatran +
					"</td><td>" + response[i].monto +
					"</td><td>" + response[i].saldo
				"</td></tr>"
			}

			$("tbody").html(contenido);
			$("table").show();

		})

		.fail(function(err) {
			console.log(err);
		});

}

function cargarupus() {
	$("#container").load("views/updateus.jsp");
	$("#Datosp").hide();//txtIdP
	$("#txtidper").hide();

	var id = { idPersona: $("#idusuario").val() };
	$.ajax({
		type: "POST",
		url: "Usuarios?parameter=search",
		dataType: "JSON",
		data: { infoid: JSON.stringify(id) },

	})
		.done(function(response) {
			console.log(response);


			if (response != '') {
				$("#txtNanme").val(response.nombre);
				$("#txtAp").val(response.apPaterno);
				$("#txtAm").val(response.apMaterno);
				$("#txtUs").val(response.usuario);
				$("#txtPass").val(response.password);
				$("#txtidper").val(response.idPersona);

			}

		})
		.fail(function(err) {
			console.log(err);
		});




}



