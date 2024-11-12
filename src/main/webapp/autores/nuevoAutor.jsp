<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de Autores</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>

<script >
	function validarFormulario(){
		const respuesta=confirm('¿Estas seguro de guardar?');
		if(respuesta){
			const nombre=document.getElementById('nombre').value.trim();
			const nacionalidad=document.getElementById('nacionalidad').value.trim();
			if(nombre===''){ //===:PARA SAER TIPO DE DATO
				alert('Ingrese el nombre del autor');
				document.getElementById('nombre').focus();
				return false;
			}else if(nombre.length!=8){
				alert('Ingrese 8 caracteres');
				document.getElementById('nombre').focus();
				return false;
			}else if(!/[1234567890]/.test(nombre)){
				alert('No cumple con el patron de caracteres');
				document.getElementById('nombre').focus();
				return false;
			}else if(!/\d/.test(nombre)){
				alert('No cumple con el patron de caracteres');
				document.getElementById('nombre').focus();
				return false;
			}
			if(nacionalidad===''){ //===:PARA SAER TIPO DE DATO
				alert('Ingrese la nacionalidad del autor');
				document.getElementById('nacionalidad').focus();
				return false;
			}
			return true;
		}else{
			return false;
		}
		
		
	}

</script>


</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	
	
	<%
		if(request.getAttribute("respuesta")!=null){
			boolean res=(boolean)request.getAttribute("respuesta");
			if(res){
				List<String> listaError=(List<String>)request.getAttribute("listaError");
				for(String error:listaError){
	%>
					<span><%=error %></span>	
					<br>		
	<% 			
				}
			}
		}
	
	%>
	
	
	
	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST" onsubmit="return validarFormulario()" class="p-4 border rounded shadow-sm bg-light">
    <input type="hidden" name="op" value="insertar" />

    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre del Autor</label>
        <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Nombre"/>
    </div>

<!-- 
class="form "
 -->
    <div class="mb-3">
        <label for="nacionalidad" class="form-label">Nacionalidad del Autor</label>
        <input type="text" name="nacionalidad" id="nacionalidad" class="form-control" placeholder="Nacionalidad" />
    </div>

    <div>
        <button type="submit" value="Guardar" name="Guardar" class="btn btn-primary">Guardar</button>
        <a href="<%=url%>AutoresController?op=listar" class="btn btn-secondary">Retorno</a>
    </div>
</form>
</body>
</html>