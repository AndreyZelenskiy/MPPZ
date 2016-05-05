<%@ page import="Model.Entity.QueriesEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.28.4
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<% String errorMessage = (String)request.getAttribute("resultText"); %>
    <div class="container">
        <%@include file="coordheader.jsp" %>
        <div class="col-md-12">
            <div  style="text-align: center">
                <h1>Неопрацьовані запити: </h1>
            </div>
        </div>
        <% List<QueriesEntity> queriesEntityList = (List<QueriesEntity>)request.getAttribute("queries");
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
        <c:forEach items="${queries}" var="queries">
            <div class="col-md-12">
                <br>
                <div class="col-md-12">
                    <div class="col-md-12" style="display:flex;">
                        <div class="col-md-2" style="font-weight: bold">
                            Назва методики:
                        </div>
                        <div class="col-md-10">
                            <c:out value="${queries.getMethod().nameOfMethodic}"/>
                        </div>
                    </div>
                    <div class="col-md-12" style="display:flex;">
                        <div class="col-md-2" style="font-weight: bold">
                            Тип методики:
                        </div>
                        <div class="col-md-10">
                            <c:out value=" ${types[queries.getMethod().methodType].toString()}"/>
                        </div>
                    </div>
                    <div class="col-md-12" style="display:flex;">
                        <div class="col-md-2" style="font-weight: bold">
                            Текст методики:
                        </div>
                        <div class="col-md-10">
                            <c:out value="${queries.getMethod().methodicText}"/>
                        </div>
                    </div>
                    <div class="col-md-12" style="display:flex;">
                        <div class="col-md-2" style="font-weight: bold">
                            Дата створення:
                        </div>
                        <div class="col-md-10">
                            <c:out value="${queries.getMethod().creatingDate}"/>
                        </div>
                        <br>
                    </div>
                    <br>
                    <div class="col-md-12">
                        <form method="post" action="/admin/coord/create">
                            <div class="row">
                                <br>
                                <input type="hidden" name="queryName" value="${queries.getMethod().nameOfMethodic}">
                                <div class="input-group">
                                    <label for="message">Оцінка методики: </label>
                                    <input type="text" id="message" name="resultText" class="form-control" placeholder="Оцінка"/>
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
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
