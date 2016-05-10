<%@ page import="Model.Entity.RegistrEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.10.5
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="justiceheader.jsp"%>
    <table style="margin-top: 30px">
        <tr>
            <th>Назва методики</th>
            <th>Тип методики</th>
            <th>Текст методики</th>
            <th>Дата створення</th>
            <th>Дія</th>
        </tr>
        <c:forEach items="${result}" var="result">
            <tr>
                <td><c:out value="${result.getMethod().nameOfMethodic}"/></td>
                <td><c:out value="${types[result.getMethod().methodType].toString()}"/></td>
                <td><c:out value="${result.getMethod().methodicText}"/></td>
                <td><c:out value="${result.getMethod().creatingDate}"/></td>
                <td>
                    <form method="post" action="/admin/just/deleted">
                        <input type="hidden" name="queryName" value="${result.getMethod().nameOfMethodic}">
                        <div>
                            <button class="btn btn-primary" type="submit" name="nameReg">
                                Видалити
                            </button>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <% List<RegistrEntity> queriesEntityList = (List<RegistrEntity>)request.getAttribute("result");
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
