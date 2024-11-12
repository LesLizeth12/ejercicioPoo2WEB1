<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Editar Autor</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String url = "http://localhost:8280/ejercicioWEB1/";
	Autor autor;
	if(request.getAttribute("autor")==null){
		autor=new Autor();
	}else{
		autor=(Autor)request.getAttribute("autor");
		
	}
	%>
	<h3>Editar Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST" class="p-4 border rounded shadow-sm bg-light">
		<input type="hidden" name="op" value="modificar" /> 
		<input type="hidden" name="id" value="<%=autor.getIdAutor()%>" /> 
		<label for="nombre"> Nombre del Autor</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" value="<%=autor.getNombre() %>" class="form-control"/> 
		<br>
		<label for="nacionalidad">Nacionalidad del Autor</label> 
		<br> 
		<input type="text" name="nacionalidad" id="nacionalidad" value="<%=autor.getNacionalidad()%>" class="form-control"/>
		<br> 
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>AutoresController?op=listar">Retorno</a>
	</form>
</body>
</html>