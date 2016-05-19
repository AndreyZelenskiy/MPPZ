<%@ page import="Model.Entity.QueriesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Entity.TypeOfQuery" %><%--
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
    <link rel="stylesheet" href="/resources/coordQuery.css">
    <meta charset="UTF-8">
</head>
<body>
<% int cnt=0;int cnt2=0;%>
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
            <div class="container">
                <div class="container col-md-6">
                    <div><label form="methodName">Назва методики: </label> <p id="methodName">${queries.getMethod().nameOfMethodic}</p> </div>
                    <div><label form="methodType">Тип методики: </label> <p id="methodType">${types[queries.getMethod().methodType].toString()}</p> </div>
                    <div><label form="methodText">Текст методики: </label><br> <p id="methodText">${queries.getMethod().methodicText}</p> </div>
                    <div><label form="queryType">Тип запиту: </label> <p id="queryType">${queries.type.toString()}</p> </div>
                    <div><label form="methodDate">Дата створення методики: </label> <p id="methodDate">${queries.getMethod().creatingDate}</p> </div>
                    <form class="form" method="post" action="/admin/coord/create">
                        <input type="hidden" name="queryName" value="${queries.getMethod().nameOfMethodic}">
                        <div class="input-group">
                            <label   for="message">Оцінка методики: </label>
                            <input type="text" id="message" name="resultText" class="form-control" placeholder="Оцінка"/>
                        </div>
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
                    </form>
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
<<<<<<< HEAD
                    <div>
                        <label form="editableMethodDate">Дата створення методики: </label>
                        <p id="editableMethodDate">${editableMethods.get(cnt).creatingDate}</p>
=======
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
                                <input type="hidden" name="queryName" value="${queries.getMethod().idMethodic}">
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
>>>>>>> 113cbd31cedec7040ef0cadf03cf637486153252
                    </div>
                </div>
                <%cnt++;}cnt2++;%>
            </div>
            <br>
            <br>
        </c:forEach>
    </div>
</body>
</html>
