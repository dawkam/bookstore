<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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
            <label>Potwierdź hasło: </label>
            <input type="password" placeholder="Potwierdź hasło" name="PasswordConfirm"/><br>
            <label>Imie: </label>
            <input type="text" placeholder="Imie" name="Name"/><br>
            <label>Nazwisko: </label>
            <input type="text" placeholder="Nazwisko" name="Surname"/><br>
            <label>Narodowość: </label>
            <input type="text" placeholder="Narodowść" name="Nation"/><br>
            <label>Miejscowość: </label>
            <input type="text" placeholder="Miejscowość" name="City"/><br>
            <label>Ulica: </label>
            <input type="text" placeholder="Ulica" name="Street"/><br>
            <label>E-mail: </label>
            <input type="text" placeholder="E-mail" name="Email"/><br>
            <button id="login_button" type="submit">Zarejestruj</button>
        </form>
        Masz już konto? <br>
        <a href="login">Zaloguj się!</a>
    </div>
</div>

</body>
</html>