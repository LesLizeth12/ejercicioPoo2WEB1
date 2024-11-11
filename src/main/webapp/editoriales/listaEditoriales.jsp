<%@page import="com.unu.poo2.beans.Editorial"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDITORIALES</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>

<script>
	function eliminar(id){
		if(confirm("¿Desea eliminar el registro?")==true){
			location.href="EditorialesController?op=eliminar&id="+id;
		}else{
			
		}
	}

</script>

</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	<div class="container text-center">

		<a type="button" href="<%=url%>EditorialesController?op=nuevo">Nuevo
			editorial</a>
		<table class="table">
			<thead>
				<tr>
					<th>Codigo del editorial</th>
					<th>Nombre del editorial</th>
					<th>Contacto del editorial</th>
					<th>Telefono del editorial</th>
					<th>Operaciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				//MAS DE UNA LINEA DE CODIGO EN JAVA
				List<Editorial> listaEditoriales = (List<Editorial>) request.getAttribute("listaEditoriales");
				if (listaEditoriales != null) {
					for (Editorial editorial : listaEditoriales) {
				%>
				<tr>
					<td><%=editorial.getIdEditorial()%></td>
					<!-- UNA SOLA LINEA DE CODIGO EN JAVA -->
					<td><%=editorial.getNombre()%></td>
					<td><%=editorial.getContacto()%></td>
					<td><%=editorial.getTelefono()%></td>
					<td><a
						href="<%=url%>EditorialesController?op=obtener&id=<%=editorial.getIdEditorial()%>" class="btn btn-warning">Modificar</a>

						<!--  
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=editorial.getIdEditorial()%>" class="btn btn-danger">Eliminar</a>
						-->
						
						<a  href="javascript:eliminar('<%=editorial.getIdEditorial()%>')" class="btn btn-danger">Eliminar</a>
						
					</td>
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