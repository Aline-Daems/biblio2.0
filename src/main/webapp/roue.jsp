<%@ page import="com.example.demo1.Personne" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 02-10-23
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>

<% Personne p = (Personne) request.getAttribute("roue"); %>
<% ArrayList<Personne> javanaisList = (ArrayList<Personne>) request.getAttribute("roue2"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bravo </title>
    <link rel="stylesheet" type="text/css" href="assets/style.css">

</head>
<body id="body">
        <p id="congrats">Félicitations  <%= p.nom%>  <%= p.prenom%>  tu as été tiré au sort !!</p>

        <% for (Personne p2 : javanaisList) {%>

           <ul>
               <li><%= p2.getPrenom() %>  </li>
           </ul>

<%}%>

        <script src="assets/script.js"></script>
</body>
</html>
