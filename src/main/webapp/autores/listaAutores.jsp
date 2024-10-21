<%@page import="com.unu.poo2.beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AUTORES</title>

</head>
<body>
ESTAMOS EN LISTA AUTORES
<table id="tabla" border="1">
	<thead>
		<tr>
			<th>Codigo del autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad del autor</th>
			<th>Operaciones</th>
		</tr>
	</thead>
	<tbody>
		<% //MAS DE UNA LINEA DE CODIGO EN JAVA
		List<Autor> listaAutores=(List<Autor>)request.getAttribute("listaAutores");
		if(listaAutores!=null){
			for(Autor autor:listaAutores){
		%>	
			<tr>
				<td><%= autor.getIdAutor() %></td> <!-- UNA SOLA LINEA DE CODIGO EN JAVA -->
				<td><%= autor.getNombre() %></td>
				<td><%= autor.getNacionalidad() %></td>
				<td></td>
			</tr>
		<%
			}
		}else{
		%>
			<tr>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
			</tr>
		<%	
		}
		 %>
		
	</tbody>
</table>
</body>
</html>