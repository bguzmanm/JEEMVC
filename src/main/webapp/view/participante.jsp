<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 04-08-21
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Participante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/estilo.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Ver Estudiante</h1>
        <jsp:include page="menu.jsp"/>
    </header>
    <h1><c:out value="${p.getNombre()}"/> <c:out value="${p.getApellido()}"/></h1>
    <p>Edad: <c:out value="${p.getEdad()}"/></p>
    <p>Email: <c:out value="${p.getEmail()}"/> </p>
    <p>Aprobado: <c:out value="${p.isAprobado()}"/> </p>
    <img src="${pageContext.request.contextPath}${p.getUrlImg()}" class="img-thumbnail" alt="${p.getNombre()} ${p.getApellido()}"/>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
