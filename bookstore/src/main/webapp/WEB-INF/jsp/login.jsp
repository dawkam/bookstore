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
        <form>
            <label>Login: </label>
            <input type="text" placeholder="Login" name="Login"/><br>
            <label>Hasło: </label>
            <input type="password" placeholder="Hasło" name="Password"/><br>
            <button id="login_button" type="submit">Zaloguj</button>
        </form>
        Nie masz konta? <br>
        <a href="register">Zarejestruj się!</a>
    </div>
</div>

</body>
</html>