<%@ page import="Model.Entity.MethodicsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Entity.RegistrEntity" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.20.5
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/css/jquery-1.12.3.min.js"></script>
    <script src="/resources/sortFunc.js"></script>
    <script src="/resources/sort.js"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <div class="container">
        <%@include file="header.jsp"%>
    </div>
    <div class="col-md-12" style="margin-top: 10px;">
        <h5>Для сортування використовуйте назви колонок таблиці</h5>
    </div>
    <div class="container">
        <table class="table">
            <tr>
                <th style="cursor: pointer;" id="name">Назва методики</th>
                <th style="cursor: pointer;" id = "type">Тип методики</th>
                <th style="cursor: pointer;" id = "text">Текст методики</th>
                <th style="cursor: pointer;" id = "date">Дата створення</th>
                <th style="cursor: pointer;" id = "end">Дата редагування</th>
                <th style="cursor: pointer;" id = "author">Автор</th>
            </tr>
            <c:forEach items="${methods}" var="methods">
                <tr>
                    <td><c:out value="${methods.getMethod().nameOfMethodic}"/></td>
                    <td><c:out value="${types[methods.getMethod().methodType].toString()}"/></td>
                    <td><c:out value="${methods.getMethod().methodicText}"/></td>
                    <td><c:out value="${methods.getMethod().creatingDate}"/></td>
                    <td><c:out value="${methods.editDate}"/></td>
                    <td><c:out value="${methods.getMethod().getAuthor().name}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <% List<RegistrEntity> queriesEntityList = (List<RegistrEntity>)request.getAttribute("methods");
        if( queriesEntityList.size() == 0){%>
    <div class="col-md-12">
        <div  style="text-align: center">
            <h4>Запиcи в реєстрі відсутні</h4>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
