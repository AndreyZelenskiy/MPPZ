<%--
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
                <th>Назва методики</th>
                <th>Тип методики</th>
                <th>Текст методики</th>
                <th>Дата створення</th>
            </tr>
            <c:forEach items="${result}" var="result">
                <tr>
                    <td><c:out value="${result.nameOfMethodic}"/></td>
                    <td><c:out value="${types[result.methodType].toString()}"/></td>
                    <td><c:out value="${result.methodicText}"/></td>
                    <td><c:out value="${result.creatingDate}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
