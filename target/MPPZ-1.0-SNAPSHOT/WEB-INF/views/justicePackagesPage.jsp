<%--
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
</head>
<body>
<div class="container">
    <%@include file="justiceheader.jsp"%>
    <c:forEach items="${dataSource}" var="dataSource">
        <div class="col-md-12">
            <br>
            <div class="col-md-12">
                <c:out value="Назва методики: ${dataSource.getMethod().nameOfMethodic}"/>
                <div class="col-md-12">
                    <c:out value="Текст методики: ${dataSource.getMethod().methodicText}"/>
                </div>
                <div class="col-md-12">
                    <c:out value="Дата створення: ${dataSource.getMethod().creatingDate}"/>
                </div>
                <br>
                <form:form method="post" modelAttribute="JucticeResultEntity" action="/admin/just/confirm">
                    <div class="row">
                        <input type="hidden" name="queryName" value="${dataSource.getMethod().nameOfMethodic}">
                        <div class="input-group">
                            <form:input type="text" path="resultText" class="form-control" placeholder="Оцінка"/>
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
                            <div style="margin-left: 40px;">
                                <button class="btn btn-primary" type="submit" name="action" value="decline">
                                    Відхилити
                                </button>
                            </div>
                        </div>
                        <hr>
                    </div>
                </form:form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
