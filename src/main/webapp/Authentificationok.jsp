<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 04-10-23
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/home.css">
    <title>Accueil</title>
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
                        <a class="nav-link active" aria-current="page" href="#">Accueil</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Livres
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/biblio2_0_war_exploded/book">Afficher</a></li>
                            <li><a class="dropdown-item" href="/biblio2_0_war_exploded/add">Ajouter</a></li>
                            <li><a class="dropdown-item" href="#">Supprimer</a></li>

                        </ul>
                    </li>
                </ul>
                <form class="d-flex" role="search" method="GET" action="/biblio2_0_war_exploded/search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="name">
                    <button class="btn btn-outline-success" type="submit" value="BookInfo">Rechercher</button>
                </form>
            </div>
        </div>
    </nav>

    <h1 class="fade-in-text d-flex justify-content-center align-items-center" id="title"> Bienvenue dans ma bibliothèque 2.0 </h1>
    <h2 class="fade-in-text d-flex justify-content-center align-items-center" id="title2"> Avec de vrais livres dont les titres sont générés par CHATGPT !!!</h2>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="assets/script.js"></script>
    </body>
</html>
