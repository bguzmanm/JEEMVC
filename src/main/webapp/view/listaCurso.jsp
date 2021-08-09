<%--
  Created by IntelliJ IDEA.
  User: brian el emperador
  Date: 04-08-21
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista del Curso</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/estilo.css">

</head>
<body>
<div class="container">
    <header>
        <h1>Lista de Curso</h1>
        <jsp:include page="menu.jsp"/>
        <h2>Código <c:out value="${codigoCurso}"></c:out></h2>
        <h3>Porcentaje de Aprobación: <f:formatNumber type="percent" maxIntegerDigits="3" maxFractionDigits="2" value="${aprobacion}"/></h3>
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
                <th>Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${participantes}">
                <tr>
                    <th>
                        <c:url var="ancla" value="/srvParticipante">
                            <c:param name="rut" value="${p.getRut()}"/>
                            <c:param name="result" value="ver"/>
                        </c:url>
                        <a href="${ancla}"><c:out value="${p.getRut()}"></c:out></a>
                    </th>
                    <td><c:out value="${p.getNombre()}"></c:out></td>
                    <td><c:out value="${p.getApellido()}"></c:out></td>
                    <td><c:out value="${p.getEdad()}"></c:out></td>
                    <td><c:out value="${p.getEmail()}"></c:out></td>
                    <td><c:out value="${p.isAprobado()}"></c:out></td>
                    <td>
                        <c:url var="editar" value="/srvParticipante">
                            <c:param name="rut" value="${p.getRut()}"/>
                            <c:param name="result" value="edit"/>
                        </c:url>
                        <c:url var="eliminar" value="/srvParticipante">
                            <c:param name="rut" value="${p.getRut()}"/>
                            <c:param name="result" value="del"/>
                        </c:url>
                        <a href="${editar}" class="btn btn-primary">Editar</a>&nbsp;<a href="${eliminar}" class="btn btn-danger">Borrar</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
