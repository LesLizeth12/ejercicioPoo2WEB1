<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.*"%>
<%@ page import="com.unu.poo2.model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de Libros</title>
</head>
<body>
	<%
	String url = "http://localhost:8280/ejercicioWEB1/";
	Autor a=new Autor(); 
	Editorial e=new Editorial();
	Genero g=new Genero();
	%>
	<h3>Nuevo Libro</h3>
	<form role="form" action="<%=url%>LibrosController" method="POST">
		<input type="hidden" name="op" value="insertar" /> 
		<label for="nombre">Nombre del Libro</label> 
		<br>
		<input type="text" name="nombre" id="nombre" /> 
		<br>
		<label for="existencia">Existencia del Libro</label> 
		<br> 
		<input type="text" name="existencia" id="existencia" /> 
		<br> 
		<label for="precio"> Precio del Libro</label> 
		<br> 
		<input type="text" name="precio" id="precio" /> 
		<br>
		<label for="descripcion"> Descripcion del Libro</label> 
		<br> 
		<input type="text" name="descripcion" id="descripcion" /> 
		<br>
		<!-- 
		<label for="autor"> Autor del Libro</label> 
		<br> 
		<input type="text" name="autor" id="autor" />
		<br>
		<label for="editorial"> Editorial del Libro</label> 
		<br> 
		<input type="text" name="editorial" id="editorial" />
		<br>
		<label for="genero"> Genero del Libro</label> 
		<br> 
		<input type="range" name="genero" id="genero" />
		<br> 
		 -->

		<!-- Combo Box para Autor -->
    <label for="autor">Autor:</label>
    <select name="autor" id="autor" required>
        <%
            AutoresModel autoresModel = new AutoresModel();
            List<Autor> listaAutores = autoresModel.listarAutores();
            for (Autor autor : listaAutores) {
        %>
            <option value="<%= autor.getIdAutor() %>"><%= autor.getNombre() %></option>
        <%
            }
        %>
    </select><br>

    <!-- Combo Box para Editorial -->
    <label for="editorial">Editorial:</label>
    <select name="editorial" id="editorial" required>
        <%
            EditorialesModel editorialesModel = new EditorialesModel();
            List<Editorial> listaEditoriales = editorialesModel.listarEditoriales();
            for (Editorial editorial : listaEditoriales) {
        %>
            <option value="<%= editorial.getIdEditorial() %>"><%= editorial.getNombre() %></option>
        <%
            }
        %>
    </select><br>

    <!-- Combo Box para Género -->
    <label for="genero">Género:</label>
    <select name="genero" id="genero" required>
        <%
            GenerosModel generosModel = new GenerosModel();
            List<Genero> listaGeneros = generosModel.listarGeneros();
            for (Genero genero : listaGeneros) {
        %>
            <option value="<%= genero.getIdGenero() %>"><%= genero.getNombre() %></option>
        <%
            }
        %>
    </select>
    <br> 
    <input type="submit" value="Guardar" name="Guardar">
			<%
			System.out.println("autor:"+a.getIdAutor()+" "+a.getNombre());
    		%>
		<a href="<%=url%>LibrosController?op=listar">Retorno</a>
	</form>
</body>
</html>