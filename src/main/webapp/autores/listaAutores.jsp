<%@page import="com.unu.poo2.beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>AUTORES</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>

<script>
	function eliminar(id){
		if(confirm("¿Desea eliminar el registro?")==true){
			location.href="AutoresController?op=eliminar&id="+id;
		}else{
			
		}
	}

</script>

</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	<div class="container text-center">

		<a type="button" href="<%=url%>AutoresController?op=nuevo">Nuevo
			autor</a>
		<table class="table table-hover table table-bordered border-primary" >
			<thead>
				<tr class="table-primary "  >
					<th>Codigo del autor</th>
					<th>Nombre del autor</th>
					<th>Nacionalidad del autor</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				//MAS DE UNA LINEA DE CODIGO EN JAVA
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
				if (listaAutores != null) {
					for (Autor autor : listaAutores) {
				%>
				<tr class="table table-sm">
					<td><%=autor.getIdAutor()%></td>
					<!-- UNA SOLA LINEA DE CODIGO EN JAVA -->
					<td><%=autor.getNombre()%></td>
					<td><%=autor.getNacionalidad()%></td>
					<td><a
						href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>" class="btn btn-warning">Modificar</a> <!--  
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>" class="btn btn-danger">Eliminar</a>
						--> <a href="javascript:eliminar('<%=autor.getIdAutor()%>')"
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