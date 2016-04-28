<%--
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
</head>
<body>
    <div class="container">
        <%@include file="coordheader.jsp" %>
        <c:forEach items="${queries}" var="queries">
            <div class="col-md-12">
                <br>
                <div class="col-md-1">
                </div>
                <div class="col-md-11">
                    <c:out value="Назва методики: ${queries.getMethod().nameOfMethodic}"/>
                    <div class="col-md-12">
                        <c:out value="Текст методики: ${queries.getMethod().methodicText}"/>
                    </div>
                    <div class="col-md-12">
                        <c:out value="Дата створення: ${queries.getMethod().creatingDate}"/>
                    </div>
                    <form:form method="post" modelAttribute="CoordinationResultsEntity" action="/admin/coord/create">
                        <div class="row">
                            <input type="hidden" name="queryName" value="${queries.getMethod().nameOfMethodic}">
                            <div class="input-group">
                                <form:input type="text" path="resultText" class="form-control" placeholder="Оцінка"/>
                            </div>
                            <div class="input-group">
                                <form:errors path="resultText" cssClass="has-error" />
                            </div>
                            <div>
                                <button class="btn btn-primary" type="submit">
                                    Далі
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
