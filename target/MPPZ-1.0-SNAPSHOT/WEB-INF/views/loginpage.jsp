<%--
  Created by IntelliJ IDEA.
  User: talizorah
  Date: 16.18.4
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вхід в систему</title>
    <link rel="stylesheet" href="/resources/login/css/style.css" media="screen" type="text/css" />
    <script src="/resources/css/jquery-1.12.3.min.js"></script>
</head>
<body>



<div id="login-form">
    <h1>Вхід в систему</h1>

    <fieldset>
        <form action="/login/sign" method="post">
            <input type="text" name="login" id="loginInput" required value="Логін" onBlur="if(this.value=='')this.value='Логін'" onFocus="if(this.value=='Логін')this.value='' ">
            <input type="password" name="password" id="passwordInput" required value="Пароль" onBlur="if(this.value=='')this.value='Пароль'" onFocus="if(this.value=='Пароль')this.value='' ">
            <input type="submit" id="loginButton" value="Вхід">
        </form>
    </fieldset>
</div>

<script>
    $( document ).ready(function() {
        $("#loginButton").click(function () {
            $("#loginInput").reset();
            $("#passwordInput").reset();
        })
    });
</script>

</body>
</html>