<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 04-10-23
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


  <form method="POST" action="/biblio2_0_war_exploded/addServlet">
    <div class="mb-3">
      <label  class="form-label">Nom du livre</label>
      <input type="Text" class="form-control" name="name">
      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Auteur</label>
      <input type="text" class="form-control" id="exampleInputPassword1" name="Auteur">
    </div>
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Année de publiation</label>
      <input type="text" class="form-control"  name="Publication">
    </div>
    <div class="mb-3 form-check">
      <input type="checkbox" class="form-check-input" id="exampleCheck1">
      <label class="form-check-label" for="exampleCheck1">Disponible</label>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
  </form>
</body>
</html>
