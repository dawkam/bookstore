<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>NewBook</title>
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
        <form method="POST" action="/register">
            <label>Login: </label>
            <input type="text" placeholder="Login" name="login"/><br>
            <label>Hasło: </label>
            <input type="password" placeholder="Hasło" name="password"/><br>
            <label>Potwierdź hasło: </label>
            <input type="password" placeholder="Potwierdź hasło" name="passwordConfirm"/><br>
            <label>Imie: </label>
            <input type="text" placeholder="Imie" name="name"/><br>
            <label>Nazwisko: </label>
            <input type="text" placeholder="Nazwisko" name="surname"/><br>
            <label>Narodowość: </label>
            <input type="text" placeholder="Narodowść" name="nation"/><br>
            <label>Miejscowość: </label>
            <input type="text" placeholder="Miejscowość" name="city"/><br>
            <label>Ulica: </label>
            <input type="text" placeholder="Ulica" name="street"/><br>
            <label>E-mail: </label>
            <input type="text" placeholder="E-mail" name="email"/><br>
            <button id="login_button" type="submit">Zarejestruj</button>
        </form>
        Masz już konto? <br>
        <a href="login">Zaloguj się!</a>
    </div>
</div>

</body>
</html>