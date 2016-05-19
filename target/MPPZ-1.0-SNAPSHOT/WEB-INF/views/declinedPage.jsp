<%@ page import="Model.Entity.MethodicsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Entity.QueriesEntity" %>
<%@ page import="Model.Entity.PackagesEntity" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.10.5
  Time: 18:45
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
    <%@include file="justiceheader.jsp" %>
    <div class="col-md-12">
        <div  style="text-align: center">
            <h1>Відхилені запити Координаційною Радою: </h1>
        </div>
        <div style="margin-top: 50px">
            <table style="margin-top: 30px">
                <tr>
                    <th>Назва методики</th>
                    <th>Тип методики</th>
                    <th>Текст методики</th>
                    <th>Дата створення</th>
                    <th>Рішення ради</th>
                </tr>
                <c:forEach items="${declinedCoord}" var="declinedCoord">
                    <tr>
                        <td><c:out value="${declinedCoord.getMethod().nameOfMethodic}"/></td>
                        <td><c:out value="${types[declinedCoord.getMethod().methodType].toString()}"/></td>
                        <td><c:out value="${declinedCoord.getMethod().methodicText}"/></td>
                        <td><c:out value="${declinedCoord.getMethod().creatingDate}"/></td>
                        <td><c:out value="${declinedCoord. getCoordinationResult().resultText}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <% List<QueriesEntity> queriesEntityList = (List<QueriesEntity>)request.getAttribute("declinedCoord");
                if( queriesEntityList.size() == 0){%>
            <div class="col-md-12">
                <div  style="text-align: center">
                    <h4>Запити відсутні </h4>
                </div>
            </div>
            <% } %>
        </div>
        <br>
        <br>
        <div  style="text-align: center">
            <h1>Відхилені запити Міністерством: </h1>
        </div>
        <div style="margin-top: 50px">
            <table style="margin-top: 30px">
                <tr>
                    <th>Назва методики</th>
                    <th>Тип методики</th>
                    <th>Текст методики</th>
                    <th>Дата створення</th>
                    <th>Рішення міністерства</th>
                </tr>
                <c:forEach items="${declinedJust}" var="declinedCoord">
                    <tr>
                        <td><c:out value="${declinedCoord.getMethod().nameOfMethodic}"/></td>
                        <td><c:out value="${types[declinedCoord.getMethod().methodType].toString()}"/></td>
                        <td><c:out value="${declinedCoord.getMethod().methodicText}"/></td>
                        <td><c:out value="${declinedCoord.getMethod().creatingDate}"/></td>
                        <td><c:out value="${declinedCoord.review}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <% List<PackagesEntity> packagesEntityList = (List<PackagesEntity>)request.getAttribute("declinedJust");
                if( packagesEntityList.size() == 0){%>
            <div class="col-md-12">
                <div  style="text-align: center">
                    <h4>Запити відсутні </h4>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>

</body>
</html>
