
function cerrar()
{
	var datosform = {usuario:$("#idusuario").val()};
	$.ajax({
		type:"POST",
		url:"Login?parameter=cerrar",
		dataType: "JSON",
		data: {info:JSON.stringify(datosform)},
		
	})
	.done(function( response ) {
			console.log(response);	
			window.location.replace('/index.jsp');
		  })
	.fail(function( err ) {
			console.log(err);	
			});
}




