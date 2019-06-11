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
            <input type="text" placeholder="Login" required minlength="3" maxlength="30" value="${user.login}"
                   name="login"/><br>
            <label>Hasło: </label>
            <input type="password" placeholder="Hasło" required minlength="3" maxlength="30" value="${user.password}"
                   name="password"/><br>
            <label>Potwierdź hasło: </label>
            <input type="password" placeholder="Potwierdź hasło" required maxlength="30" value="${passwordConfirm}"
                   name="passwordConfirm"/><br>
            <label>Imie: </label>
            <input type="text" placeholder="Imie" required minlength="3" maxlength="30" value="${user.firstName}"
                   name="name"/><br>
            <label>Nazwisko: </label>
            <input type="text" placeholder="Nazwisko" required minlength="3" maxlength="30" value="${user.surname}"
                   name="surname"/><br>
            <label>Narodowość: </label>
            <input type="text" placeholder="Narodowść" required minlength="3" maxlength="30" value="${user.nation}"
                   name="nation"/><br>
            <label>Miejscowość: </label>
            <input type="text" placeholder="Miejscowość" required minlength="3" maxlength="30" value="${user.city}"
                   name="city"/><br>
            <label>Ulica: </label>
            <input type="text" placeholder="Ulica" required minlength="3" maxlength="30" value="${user.street}"
                   name="street"/><br>
            <label>E-mail: </label>
            <input type="text" placeholder="E-mail" required minlength="3" maxlength="30" value="${user.email}"
                   name="email"/><br>
            <button id="login_button" type="submit">Zarejestruj</button>
        </form>
        Masz już konto? <br>
        <a href="login">Zaloguj się!</a>
    </div>
</div>
< <c:if test="${error != null}">

    <script>
        alert("${error}");
    </script>
</c:if>

</body>
</html>