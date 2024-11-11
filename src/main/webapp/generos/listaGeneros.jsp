<%@page import="com.unu.poo2.beans.Genero"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Generos</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>

<script>
	function eliminar(id){
		if(confirm("¿Desea eliminar el registro?")==true){
			location.href="GenerosController?op=eliminar&id="+id;
		}else{
			
		}
	}

</script>

</head>
<body>
	<%
	String url = "http://localhost:8080/ejercicioWEB1/";
	%>
	<div class="container">

		<a type="button" href="<%=url%>GenerosController?op=nuevo">Nuevo
			Genero</a>
		<table class="table">
			<thead>
				<tr>
					<th>Codigo del Genero</th>
					<th>Nombre del Genero</th>
					<th>Descripcion del Genero</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				//MAS DE UNA LINEA DE CODIGO EN JAVA
				List<Genero> listaGeneros = (List<Genero>) request.getAttribute("listaGeneros");
				if (listaGeneros != null) {
					for (Genero genero : listaGeneros) {
				%>
				<tr>
					<td><%=genero.getIdGenero()%></td>
					<!-- UNA SOLA LINEA DE CODIGO EN JAVA -->
					<td><%=genero.getNombre()%></td>
					<td><%=genero.getDescripcion()%></td>
					<td><a
						href="<%=url%>GenerosController?op=obtener&id=<%=genero.getIdGenero()%>"
						class="btn btn-warning">Modificar</a> <!--  
						<a
						href="<%=url%>GenerosController?op=eliminar&id=<%=genero.getIdGenero()%>" class="btn btn-danger">Eliminar</a>
						--> <a href="javascript:eliminar('<%=genero.getIdGenero()%>')"
						class="btn btn-danger">Eliminar</a></td>
				</tr>
				<%
					}
				} else {
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
	</div>
</body>
</html>