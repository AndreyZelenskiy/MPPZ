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
    <title>Title</title>
</head>
<body>
    <div class="container">
        <%@include file="header.jsp"%>
        <table style="margin-top: 30px">
            <tr>
                <th>Назва методики</th>
                <th>Текст методики</th>
                <th>Дата створення</th>
            </tr>
            <c:forEach items="${methods}" var="methods">
                <tr>
                    <td><c:out value="${methods.nameOfMethodic}"/></td>
                    <td><c:out value="${methods.methodicText}"/></td>
                    <td><c:out value="${methods.creatingDate}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
