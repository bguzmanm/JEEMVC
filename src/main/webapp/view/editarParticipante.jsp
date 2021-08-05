<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 05-08-21
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Participante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/estilo.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Editar Estudiante</h1>
        <jsp:include page="menu.jsp"/>
    </header>
    <form action="#" method="post">
        <div class="mb-3">
            <label for="rut" class="form-label">Rut</label>
            <input type="text" class="form-control" id="rut" value="${p.getRut()}">
        </div>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" value="${p.getNombre()}">
        </div>
        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellido" value="${p.getApellido()}">
        </div>
        <div class="mb-3">
            <label for="edad" class="form-label">Edad</label>
            <input type="number" class="form-control" id="edad" value="${p.getEdad()}">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" value="${p.getEmail()}">
        </div>
        <div class="mb-3">
            <label for="aprobado" class="form-label">Aprobado</label>
            <c:if test="${p.isAprobado()}">
                <input type="checkbox" class="form-check-input mt-0" id="aprobado" checked>
            </c:if>
            <c:if test="${!p.isAprobado()}">
                <input type="checkbox" class="form-check-input mt-0" id="aprobado">
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
        <button type="reset" class="btn btn-secondary">Reset</button>

    </form>
    <jsp:include page="footer.jsp"/>
</div>


</body>
</html>