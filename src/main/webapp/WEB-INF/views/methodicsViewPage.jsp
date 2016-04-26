<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.26.4
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/myStyleMethod.css">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <%@include file="header.jsp"%>
            <c:forEach items="${methods}" var="methods">
                <div class="col-md-12">
                    <br>
                    <div class="col-md-1">
                    </div>
                    <div class="col-md-11">
                        <c:out value="Назва методики: ${methods.nameOfMethodic}"/>
                        <div class="col-md-12">
                            <c:out value="Текст методики: ${methods.methodicText}"/>
                        </div>
                        <div class="col-md-12">
                            <c:out value="Дата створення: ${methods.creatingDate}"/>
                        </div>
                    </div>
                </div>
            </c:forEach>
    </div>
</body>
</html>
