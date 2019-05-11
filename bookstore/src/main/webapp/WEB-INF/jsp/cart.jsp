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
            <input type="text" placeholder="Login" name="login"/><br>
            <label>Hasło: </label>
            <input type="password" placeholder="Hasło" name="password"/><br>
            <button id="login_button" type="submit">Zaloguj</button>
        </form>
        Nie masz konta? <br>
        <a href="register">MUHAHAHAHAHHHAHA!</a>
    </div>
</div>

</body>
</html>