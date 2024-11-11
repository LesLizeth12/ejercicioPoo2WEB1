<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de Generos</title>
</head>
<body>
	<%
	String url="http://localhost:8080/ejercicioWEB1/";
	%>
	<h3>Nuevo Genero</h3>
	<form role="form" action="<%=url%>GenerosController" method="POST">
		<input type="hidden" name="op" value="insertar" /> 
		<label for="nombre">Nombre del Genero</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" /> 
		<br>
		<label for="descripcion"> Descripcion del Genero</label> 
		<br> 
		<input type="text" name="descripcion" id="descripcion" />
		<br> 
		<input type="submit" value="Guardar" name="Guardar">  
		<a href="<%=url%>GenerosController?op=listar">Retorno</a>
	</form>
</body>
</html>