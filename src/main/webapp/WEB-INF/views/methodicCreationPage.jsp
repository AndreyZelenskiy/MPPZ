<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.19.4
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>
    <div class="container">
        <%@include file="devheader.jsp" %>
        <form:form method="post" modelAttribute="MethodicsEntity" action="/admin/dev/create">
            <div class="row" style="text-align: center">
                <div class="col-lg-12 col-lg-offset-5" style="text-align: center">
                    <div class="input-group">
                        <form:input type="text" path="nameOfMethodic" class="form-control" placeholder="Назва методики"/>
                    </div>
                    <div class="input-group">
                        <form:errors path="nameOfMethodic" cssClass="has-error" />
                    </div>
                    <div class="input-group">
                        <form:input type="textarea" rows="3" path="methodicText" class="form-control" placeholder="Текст методики"/>
                    </div>
                    <div class="input-group">
                        <form:errors path="methodicText" cssClass="has-error" />
                    </div>
                    <div style="text-align:center;">
                        <button class="btn btn-primary" type="submit">
                            Далі
                        </button>
                    </div>
                </div>
        </form:form>
    </div>
</body>
</html>
