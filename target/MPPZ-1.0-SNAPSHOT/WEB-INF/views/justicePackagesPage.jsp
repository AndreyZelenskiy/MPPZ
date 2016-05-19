<%@ page import="Model.Entity.PackagesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Entity.TypeOfQuery" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.4.5
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/coordQuery.css">
</head>
<body>

<% int cnt2=0;%>
<c:set var="cnt" value="0"/>
<% String errorMessage = (String)request.getAttribute("resultText"); %>
<div class="container">
    <%@include file="justiceheader.jsp"%>
    <div class="col-md-12">
        <div  style="text-align: center">
            <h1>Неопрацьовані запити: </h1>
        </div>
    </div>
    <% List<PackagesEntity> queriesEntityList = (List<PackagesEntity>)request.getAttribute("dataSource");
        if( queriesEntityList.size() == 0){%>
    <div class="col-md-12">
        <div  style="text-align: center">
            <h4>Нові запити відсутні </h4>
        </div>
    </div>
    <% } %>
    <div>
        <%
            if(errorMessage != null){
        %>
        <div class="col-md-12" style="width: 66%;">
            <h4>
                <%=errorMessage%>
            </h4>
        </div>
        <% } %>
    </div>
    <c:forEach items="${dataSource}" var="dataSource" varStatus="index">
            <div class="container">
                <div class="container col-md-6">
                    <div><label form="methodName">Назва методики: </label> <p id="methodName">${dataSource.getMethod().nameOfMethodic}</p> </div>
                    <div><label form="methodType">Тип методики: </label> <p id="methodType">${types[dataSource.getMethod().methodType].toString()}</p> </div>
                    <div><label form="methodText">Текст методики: </label><br> <p id="methodText">${dataSource.getMethod().methodicText}</p> </div>
                    <div><label form="queryType">Тип запиту: </label> <p id="queryType">${dataSource.type.toString()}</p> </div>
                    <div><label form="methodDate">Дата створення методики: </label> <p id="methodDate">${dataSource.getMethod().creatingDate}</p> </div>
                    <div><label form="methodDate">Рішення координаційної ради: </label> <p id="coordResult">${dataSource.getCoordinationResult().resultText}</p> </div>
                    <form:form method="post" modelAttribute="JucticeResultEntity" action="/admin/just/confirm">
                        <div class="row">

                            <input type="hidden" name="queryName" value="${dataSource.getMethod().nameOfMethodic}">
                            <div class="input-group">
                                <label for="message">Оцінка методики: </label>
                                <form:input type="text" id="message" path="resultText" class="form-control" placeholder="Оцінка"/>
                            </div>
                            <div class="input-group">
                                <form:errors path="resultText" cssClass="has-error" />
                            </div>
                            <br>
                            <div style="display: flex">
                                <div>
                                    <button class="btn btn-primary" type="submit" name="action" value="confirm">
                                        Прийняти
                                    </button>
                                </div>
                                <div style="margin-left: 120px;">
                                    <button class="btn btn-primary" type="submit" name="action" value="decline">
                                        Відхилити
                                    </button>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </form:form>
                </div>
                <%if(queriesEntityList.get(cnt2).getType() == TypeOfQuery.EDIT){%>
                <div class="container col-md-6">
                    <div>
                        <label form="editableMethodName">Назва методики: </label>
                        <p id="editableMethodName">${editableMethods.get(cnt).nameOfMethodic}</p>
                    </div>
                    <div>
                        <label form="editableMethodType">Тип методики: </label>
                        <p id="editableMethodType">${types[editableMethods.get(cnt).methodType].toString()}</p>
                    </div>
                    <div>
                        <label form="editableMethodText">Текст методики: </label>
                        <p id="editableMethodText">${editableMethods.get(cnt).methodicText}</p>
                    </div>
                    <div>
                        <label form="editableMethodDate">Дата створення методики: </label>
                        <p id="editableMethodDate">${editableMethods.get(cnt).creatingDate}</p>
                    </div>
                </div>
                <c:set var="cnt" value="${cnt} + 1"/>
                <%;} cnt2++;%>
            </div>
            <br>
            <br>
    </c:forEach>
</div>
</body>
</html>
