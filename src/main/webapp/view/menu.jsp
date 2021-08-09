<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 05-08-21
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="srvCurso">Ver Curso</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="srvParticipante?result=crear">Nuevo Participante</a>
        </li>
      </ul>
    </div>
  </div>
</nav>