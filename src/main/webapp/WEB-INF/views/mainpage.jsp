<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.18.4
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/navbar.css">
    <title>Title</title>
</head>
<body>

<c:url value="/login" var="methodShow" />

<div class="container">
    <div class="col-md-12">
        <ul>
            <li><a>Home</a></li>
            <li><a>News</a></li>
            <li style="float:right"><a href="${methodShow}">Вхід в систему</a></li>
        </ul>
        <div  style="text-align: center">
            <h1> Єдиний реєстр методик судових експертиз України</h1>
        </div>
    </div>
    <br>
    <br>
    <br>
</div>

</body>
</html>
