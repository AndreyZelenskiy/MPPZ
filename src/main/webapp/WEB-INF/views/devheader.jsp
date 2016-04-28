<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.27.4
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/navbar.css">
    <title>Title</title>
</head>
<body>
<c:url value="/methods/show" var="showMethods"/>
<c:url value="/mainpage" var="showMainpage"/>
<c:url value="/logout" var="logout"/>
<c:url value="/admin/dev/show" var="createMethod"/>
<c:url value="/admin/dev/queries" var="showQueries" />
    <ul>
        <li><a href="${showMainpage}">Головна</a></li>
        <li><a href="${showMethods}">Методики</a></li>
        <li><a href="${createMethod}">Створення методики</a></li>
        <li><a href="${showQueries}">Мої запити</a></li>
        <li style="float:right"><a href="${logout}">Вихід з системи</a></li>
    </ul>
</body>
</html>
