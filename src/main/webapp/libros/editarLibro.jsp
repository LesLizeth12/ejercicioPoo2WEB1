<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unu.poo2.beans.*" %>
	<%@ page import="com.unu.poo2.model.*"%>
	<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Editar Libro</title>
</head>
<body>
	<%
	String url = "http://localhost:8280/ejercicioWEB1/";
	Libro libro;
	if(request.getAttribute("libro")==null){
		libro=new Libro();
	}else{
		libro=(Libro)request.getAttribute("libro");
		
	}
	%>
	<h3>Editar Libro</h3>
	<form role="form" action="<%=url%>LibrosController" method="POST">
		<input type="hidden" name="op" value="modificar" /> 
		<input type="hidden" name="id" value="<%=libro.getIdLibro()%>" /> 
		<label for="nombre"> Nombre del Libro</label> 
		<br> 
		<input type="text" name="nombre" id="nombre" value="<%=libro.getNombre() %>" /> 
		<br>
		<label for="existencia">Existencia del Libro</label> 
		<br> 
		<input type="text" name="existencia" id="existencia" value="<%=libro.getExistencia()%>"/>
		<br> 
		<label for="precio">Precio del Libro</label> 
		<br> 
		<input type="text" name="precio" id="precio" value="<%=libro.getPrecio()%>"/>
		<br> 
		<label for="descripcion">Descripcion del Libro</label> 
		<br> 
		<input type="text" name="descripcion" id="descripcion" value="<%=libro.getDescripcion()%>"/>
		<br> 
		
		<!-- Combo Box para Autor -->
<label for="autor">Autor:</label>
<select name="autor" id="autor" required>
    <%
        AutoresModel autoresModel = new AutoresModel();
        List<Autor> listaAutores = autoresModel.listarAutores();
        for (Autor autor : listaAutores) {
            // Compara el nombre del autor del libro con el nombre del autor en la lista
            boolean isSelected = autor.getNombre().equals(libro.getAutor());
    %>
        <option value="<%= autor.getIdAutor() %>" <%= isSelected ? "selected" : "" %>>
            <%= autor.getNombre() %>
        </option>
    <%
        }
    %>
</select><br>

<label for="editorial">Editorial:</label>
<select name="editorial" id="editorial" required>
    <%
        EditorialesModel editorialesModel = new EditorialesModel();
        List<Editorial> listaEditoriales = editorialesModel.listarEditoriales();
        for (Editorial editorial : listaEditoriales) {
            boolean isSelected = editorial.getNombre().equals(libro.getEditorial());
    %>
        <option value="<%= editorial.getIdEditorial() %>" <%= isSelected ? "selected" : "" %>>
            <%= editorial.getNombre() %>
        </option>
    <%
        }
    %>
</select><br>

<label for="genero">Género:</label>
<select name="genero" id="genero" required>
    <%
        GenerosModel generosModel = new GenerosModel();
        List<Genero> listaGeneros = generosModel.listarGeneros();
        for (Genero genero : listaGeneros) {
            boolean isSelected = genero.getNombre().equals(libro.getGenero());
    %>
        <option value="<%= genero.getIdGenero() %>" <%= isSelected ? "selected" : "" %>>
            <%= genero.getNombre() %>
        </option>
    <%
        }
    %>
</select><br>
		
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>LibrosController?op=listar">Retorno</a>
	</form>
</body>
</html>