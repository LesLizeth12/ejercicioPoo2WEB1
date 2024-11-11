<%@page import="com.unu.poo2.beans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>LIBROS</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>

<script>
	function eliminar(id){
		if(confirm("¿Desea eliminar el registro?")==true){
			location.href="LibrosController?op=eliminar&id="+id;
		}else{
			
		}
	}

</script>

</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	<div class="container text-center">

		<a type="button" href="<%=url%>LibrosController?op=nuevo">Nuevo
			Libro</a>
		<table class="table">
			<thead>
				<tr>
					<th>Codigo del libro</th>
					<th>Nombre del libro</th>
					<th>Existencia del libro</th>
					<th>Precio del libro</th>
					<th>Descripcion del libro</th>
					<th>Nombre del autor</th>
					<th>Nombre del editorial</th>
					<th>Nombre del genero</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				//MAS DE UNA LINEA DE CODIGO EN JAVA
				List<Libro> listaLibros = (List<Libro>) request.getAttribute("listaLibros");
				if (listaLibros != null) {
					for (Libro libro : listaLibros) {
				%>
				<tr>
					<td><%=libro.getIdLibro()%></td>
					<td><%=libro.getNombre()%></td>
					<td><%=libro.getExistencia()%></td>
					<td><%=libro.getPrecio()%></td>
					<td><%=libro.getDescripcion()%></td>
					<td><%=libro.getAutor()%></td>
					<td><%=libro.getEditorial()%></td>
					<td><%=libro.getGenero()%></td>
					<td><a
						href="<%=url%>LibrosController?op=obtener&id=<%=libro.getIdLibro()%>"
						class="btn btn-warning">Modificar</a> <!--  
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=libro.getIdLibro()%>" class="btn btn-danger">Eliminar</a>
						--> <a href="javascript:eliminar('<%=libro.getIdLibro()%>')"
						class="btn btn-danger">Eliminar</a>
						<td>
				</tr>
				<%
					}
				} else {
				%>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
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