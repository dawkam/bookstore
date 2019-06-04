<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/loginPage.css">
    <link rel="stylesheet" href="/homePage.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="top_panel">
    <div class="logo">
        <img src="/logo.png" alt="logo" height="94" class="logo" onclick="location.href='/home'">
    </div>
    <div class="search_bar">
        <form method="GET" action="/home">
            <label>Szukaj</label>
            <input type="text" placeholder="Search.." name="bookName"/>
            <button class="standard_button" type="submit">Wyszukaj</button>
        </form>
    </div>
    <div class="profile_button">
        <button onclick="location.href='/shoppingCart'" type="submit">Koszyk</button>
    </div>
        <div class="cart_button">
            <form method="POST" action="/logout">
                <button type="submit">Wyloguj</button>
            </form>
        </div>
</div>
<div id="contents">
    <div id="reported_button">
        <c:if test="${user.getRoleU().getIdRole() == 2}">
            <div>
                <button id="reported" onclick="location.href='/reported'" type="submit">Do zareportowanych komentarzy!</button>
            </div>
        </c:if>
    </div>
    <div id="login_form">
        <br>
        <form method="POST" action="/profile">
            <label>Hasło: </label>
            <input type="password" value = ${user.password} name="password"/><br>
            <label>Potwierdź hasło: </label>
            <input type="password" placeholder="Potwierdź hasło" name="passwordConfirm"/><br>
            <label>Imie: </label>
            <input type="text" value = ${user.firstName} name="name"/><br>
            <label>Nazwisko: </label>
            <input type="text" value = ${user.surname} name="surname"/><br>
            <label>Narodowość: </label>
            <input type="text" value = ${user.nation} name="nation"/><br>
            <label>Miejscowość: </label>
            <input type="text" value = ${user.city} name="city"/><br>
            <label>Ulica: </label>
            <input type="text" value = ${user.street} name="street"/><br>
            <label>E-mail: </label>
            <input type="text" value = ${user.email} name="email"/><br>
            <button id="save_button" type="submit">Zapisz zmiany</button>
        </form>
    </div>
</div>

</body>
</html>