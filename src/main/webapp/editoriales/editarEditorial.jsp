<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Editorial </title>
</head>
<body>
	<%
	String url = "http://localhost:8280/ejercicioWEB1/";
	Editorial editorial;
	if(request.getAttribute("editorial")==null){
		editorial=new Editorial();
	}else{
		editorial=(Editorial)request.getAttribute("editorial");
		
	}
	%>
	<h3>Editar Editorial</h3>
	<form role="form" action="<%=url%>EditorialesController" method="POST">
		<input type="hidden" name="op" value="modificar" /> 
		<input type="hidden" name="id" value="<%=editorial.getIdEditorial()%>" /> 
		
		<label for="nombre"> Nombre del Editorial</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" value="<%=editorial.getNombre() %>" /> 
		<br> 
		<label for="contacto">Contacto del Editorial</label> 
		<br> 
		<input type="text" name="contacto" id="contacto" value="<%=editorial.getContacto()%>"/>
		<br> 
		<label for="telefono">Telefono del Editorial</label> 
		<br> 
		<input type="text" name="telefono" id="telefono" value="<%=editorial.getTelefono()%>"/>
		<br>
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>EditorialesController?op=listar">Retorno</a>
	</form>
</body>
</html>