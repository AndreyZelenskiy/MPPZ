<%@ page import="Model.Entity.MethodicsEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.8.5
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/css/jquery-1.12.3.min.js"></script>
    <script src="/resources/sortFunc.js"></script>
    <script src="/resources/sort.js"></script>
</head>
<body>
<div class="container">
    <%@include file="header.jsp"%>
    <div class="col-md-12">
        <div  style="text-align: center">
            <h1>Система пошуку</h1>
        </div>
        <br>
        <br>
    </div>

    <form action="/search//found" method="post">
            <div class="col-md-4">
                <label for="nameLabel">Назва потрібної методики:</label>
                <input type="text" id="nameLabel" class="form-control" name="methodName" placeholder="Назва методики">
            </div>
            <div class="col-md-4 col-md-offset-2">
                <input type="checkbox" name="formDoor[]" value="Complex" />Комплексна експертиза<br />
                <input type="checkbox" name="formDoor[]" value="Write" />Почеркознавча експертиза<br />
                <input type="checkbox" name="formDoor[]" value="Technic" />Технічна експертиза<br />
                <div align="left">
                    <br>
                    <button class="btn btn-primary" name="formSubmit" type="submit">
                        Пошук
                    </button>
                </div>
            </div>
    </form>
    <div style="margin-top: 50px">
        <table style="margin-top: 30px">
            <tr>
                <th style="cursor: pointer;" id="name">Назва методики</th>
                <th style="cursor: pointer;" id = "type">Тип методики</th>
                <th style="cursor: pointer;" id = "text">Текст методики</th>
                <th style="cursor: pointer;" id = "date">Дата створення</th>
                <th style="cursor: pointer;" id = "end">Дата редагування</th>
                <th style="cursor: pointer;" id = "author">Автор</th>
            </tr>
            <c:forEach items="${methods}" var="methods">
                <tr>
                    <td><c:out value="${methods.getMethod().nameOfMethodic}"/></td>
                    <td><c:out value="${types[methods.getMethod().methodType].toString()}"/></td>
                    <td><c:out value="${methods.getMethod().methodicText}"/></td>
                    <td><c:out value="${methods.getMethod().creatingDate}"/></td>
                    <td><c:out value="${methods.editDate}"/></td>
                    <td><c:out value="${methods.getMethod().getAuthor().name}"/></td>
                </tr>
            </c:forEach>
        </table>
        <% List<MethodicsEntity> queriesEntityList = (List<MethodicsEntity>)request.getAttribute("methods");
            if(queriesEntityList != null)
                if(queriesEntityList.size() == 0){%>
        <div class="col-md-12">
            <div  style="text-align: center">
                <h4>По вашому запиту результат відсутній</h4>
            </div>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>
