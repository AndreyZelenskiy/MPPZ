<%@ page import="Model.Entity.MethodicsEntity" %>
<%@ page import="java.util.List" %><%--
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
    <script src="/resources/css/jquery-1.12.3.min.js"></script>
    <script src="/resources/sortFunc.js"></script>
    <script src="/resources/sort.js"></script>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <%@include file="header.jsp"%>
        <div class="col-md-12" style="margin-top: 10px;">
            <h5>Для сортування використовуйте назви колонок таблиці</h5>
        </div>
        <table style="margin-top: 30px">
            <tr>
                <th style="cursor: pointer;" id="name">Назва методики</th>
                <th style="cursor: pointer;" id = "type">Тип методики</th>
                <th style="cursor: pointer;" id = "text">Текст методики</th>
                <th style="cursor: pointer;" id = "date">Дата створення</th>
            </tr>
            <c:forEach items="${methods}" var="methods">
                <tr>
                    <td><c:out value="${methods.nameOfMethodic}"/></td>
                    <td><c:out value="${types[methods.methodType].toString()}"/></td>
                    <td><c:out value="${methods.methodicText}"/></td>
                    <td><c:out value="${methods.creatingDate}"/></td>
                </tr>
            </c:forEach>
        </table>
        <% List<MethodicsEntity> queriesEntityList = (List<MethodicsEntity>)request.getAttribute("methods");
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
