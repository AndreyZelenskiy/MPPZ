<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.4.5
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/navbar.css">
</head>
<body>
<c:url value="/methods/show" var="showMethods"/>
<c:url value="/mainpage" var="showMainpage"/>
<c:url value="/admin/just/show" var="showPackages"/>
<c:url value="/logout" var="logout"/>
<div class="container">
    <ul>
        <li><a href="${showMainpage}">Головна</a></li>
        <li><a href="${showMethods}">Методики</a></li>
        <li><a href="${showPackages}">Запити</a></li>
        <li style="float:right"><a href="${logout}">Вихід з системи</a></li>
    </ul>
</div>
</body>
</html>
