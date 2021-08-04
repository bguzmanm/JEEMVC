<%--
  Created by IntelliJ IDEA.
  User: brian el emperador
  Date: 04-08-21
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista del Curso</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <header>
        <h1>Lista de Curso</h1>
        <h2>Código <c:out value="${codigoCurso}"></c:out></h2>
        <h3>Porcentaje de Aprobación: <c:out value="${aprobacion}"></c:out></h3>
    </header>
    <div>
        <table class="table">
            <thead class="table-dark">
            <tr>
                <th>Rut</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Email</th>
                <th>Aprobado</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${participantes}">
                <tr>
                    <th>
                        <c:url var="ancla" value="/srvParticipante">
                            <c:param name="rut" value="${p.getRut()}"/>
                        </c:url>
                        <a href="${ancla}"><c:out value="${p.getRut()}"></c:out></a>
                    </th>
                    <td><c:out value="${p.getNombre()}"></c:out></td>
                    <td><c:out value="${p.getApellido()}"></c:out></td>
                    <td><c:out value="${p.getEdad()}"></c:out></td>
                    <td><c:out value="${p.getEmail()}"></c:out></td>
                    <td><c:out value="${p.isAprobado()}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
