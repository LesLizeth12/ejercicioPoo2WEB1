<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Editorial</title>
</head>
<body>
	<%
	String url = "http://localhost:8080/ejercicioWEB1/";
	%>
	<h3>Nuevo Editorial</h3>
	<form role="form" action="<%=url%>EditorialesController" method="POST">
		<input type="hidden" name="op" value="insertar" /> 
		<label for="nombre"> Nombre del Editorial</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" /> 
		<br> 
		<label for="contacto">Contacto del Editorial</label> 
		<br> 
		<input type="text" name="contacto" id="contacto" />
		<br> 
		<label for="telefono">Telefono del Editorial</label> 
		<br> 
		<input type="text" name="telefono" id="telefono" />
		<br> 
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>EditorialesController?op=listar">Retorno</a>
	</form>
</body>
</html>