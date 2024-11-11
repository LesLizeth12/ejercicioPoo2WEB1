<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingreso de Autores</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String url="http://localhost:8080/ejercicioWEB1/";
	%>
	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST" class="p-4 border rounded shadow-sm bg-light">
    <input type="hidden" name="op" value="insertar" />

    <!-- Nombre del Autor -->
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre del Autor</label>
        <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Nombre" required />
    </div>

    <!-- Nacionalidad del Autor -->
    <div class="mb-3">
        <label for="nacionalidad" class="form-label">Nacionalidad del Autor</label>
        <input type="text" name="nacionalidad" id="nacionalidad" class="form-control" placeholder="Nacionalidad" required />
    </div>

    <!-- Botones de acción -->
    <div class="d-flex justify-content-between mt-4">
        <button type="submit" value="Guardar" name="Guardar" class="btn btn-primary">Guardar</button>
        <a href="<%=url%>AutoresController?op=listar" class="btn btn-secondary">Retorno</a>
    </div>
</form>
</body>
</html>