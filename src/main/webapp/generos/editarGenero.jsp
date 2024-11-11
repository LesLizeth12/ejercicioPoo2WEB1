<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Editar Genero</title>
</head>
<body>
	<%
	String url = "http://localhost:8080/ejercicioWEB1/";
	Genero genero;
	if(request.getAttribute("genero")==null){
		genero=new Genero();
	}else{
		genero=(Genero)request.getAttribute("genero");
		
	}
	%>
	<h3>Editar Genero</h3>
	<form role="form" action="<%=url%>GenerosController" method="POST">
		<input type="hidden" name="op" value="modificar" /> 
		<input type="hidden" name="id" value="<%=genero.getIdGenero()%>" /> 
		<label for="nombre"> Nombre del Genero</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" value="<%=genero.getNombre() %>" /> 
		<br>
		<label for="descripcion">descripcion del Genero</label> 
		<br> 
		<input type="text" name="descripcion" id="descripcion" value="<%=genero.getDescripcion()%>"/>
		<br> 
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>GenerosController?op=listar">Retorno</a>
	</form>
</body>
</html>