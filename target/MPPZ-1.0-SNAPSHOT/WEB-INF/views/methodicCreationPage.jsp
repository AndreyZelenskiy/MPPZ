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
    <link rel="stylesheet" href="/resources/methodView.css">
</head>
<body>
    <div class="container">
        <%@include file="devheader.jsp" %>
        <form method="post" action="/admin/dev/create">
            <% String errorMessage = (String)request.getAttribute("createResult"); %>
            <div class="row" style="margin-top: 50px">
                <div class="col-md-12">
                    <div  style="text-align: center">
                        <h1>Створення методики</h1>
                    </div>
                </div>
                <br>
                <br>
                <div class="col-md-12">
                    <label for="name">Введіть назву методики: </label>
                    <div>
                        <input path="nameOfMethodic" name="methodName" type="text" id="name"/>
                    </div>
                    <br>
                    <label for="select">Виберіть тип методики: </label>
                    <div style="width: 200px" id="select">
                        <select name="methodType">
                            <option value="Complex">Комплексна експертиза</option>
                            <option value="Write">Почеркознавча</option>
                            <option value="Technic">Технічна</option>
                        </select>
                    </div>
                    <br>
                    <label for="comment">Методика:</label>
                    <textarea class="form-control" id="comment" name="methodText" rows!="5"></textarea>
                    <br>
                    <div align="right">
                        <button class="btn btn-primary" type="submit">
                            Створити
                        </button>
                    </div>
                </div>
        </form>
    </div>
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
</body>
</html>
