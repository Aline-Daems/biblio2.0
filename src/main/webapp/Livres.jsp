<%@ page import="be.technobel.adae.Livres" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 04-10-23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% ArrayList<Livres> bookList = (ArrayList<Livres>) request.getAttribute("book"); %>
        <html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

  <title>Livres - Afficher</title>
</head>
<body>


<nav class="navbar navbar-expand-lg  bg-dark border-body" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Bibliotheque 2.0</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/biblio2_0_war_exploded/Authentificationok.jsp">Accueil</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Livres
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/biblio2_0_war_exploded/book">Afficher</a></li>
            <li><a class="dropdown-item" href="#">Ajouter</a></li>
            <li><a class="dropdown-item" href="#">Supprimer</a></li>

          </ul>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<table class="table table-dark table-hover">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Titre</th>
    <th scope="col">Année de publication</th>
    <th scope="col">Auteur</th>
    <th scope="col">Disponibilité</th>
  </tr>
  </thead>
  <tbody>

  <% if (bookList != null) { %>
  <% int rowNum =1;%>
  <% for(Livres book : bookList) { %>


  <tr>
    <td> <%= rowNum++%></td>
    <td><%= book.getNom()%></td>
    <td><%= book.getAnneePublication()%></td>
    <td><%= book.getAuteur()%></td>
    <td><%= book.getDispo()%></td>

  </tr>

  <%}%>
  <% } %>
  </tbody>
</table>

</body>
</html>
