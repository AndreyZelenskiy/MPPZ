<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.27.4
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/resources/css/navbar.css">
    <title>Title</title>
</head>
<body>
<% String username = (String)request.getAttribute("username"); %>
    <div class="container">
        <%@include file="devheader.jsp" %>
        <div class="col-md-12">
            <div  style="text-align: center">
                <h1>${username}, вітаємо вас в системі!</h1>
            </div>
        </div>
    </div>
</body>
</html>
