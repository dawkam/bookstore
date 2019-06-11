<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/loginPage.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div id="contents">
    <div class="logo">
        <img src="/logo.png" alt="logo" height="94" class="logo" onclick="location.href='/home'">
    </div>
    <div id="login_form">
        <br>
        <form method="POST" action="/login">
            <label>Login: </label>
            <input type="text" placeholder="Login" required minlength="3" maxlength="30" name="login"/><br>
            <label>Hasło: </label>
            <input type="password" placeholder="Hasło" required maxlength="30" name="password"/><br>
            <button id="login_button" type="submit">Zaloguj</button>
        </form>
        Nie masz konta? <br>
        <a href="register">Zarejestruj się!</a>
    </div>
</div>
< <c:if test="${error != null}">

    <script>
        alert("${error}");
    </script>
</c:if>
</body>
</html>