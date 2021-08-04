<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 04-08-21
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Participante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">

    <h1><c:out value="${p.getNombre()}"/> <c:out value="${p.getApellido()}"/></h1>
    <p>Edad: <c:out value="${p.getEdad()}"/></p>
    <p>Email: <c:out value="${p.getEmail()}"/> </p>
    <p>Aprobado: <c:out value="${p.isAprobado()}"/> </p>

</div>
</body>
</html>
