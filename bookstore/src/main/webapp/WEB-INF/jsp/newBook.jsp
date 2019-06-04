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
        <form method="POST" action="/newBook">
            <label>Tytuł: </label>
            <input type="text" placeholder="Tytuł" name="title"/><br>
            <label>Autor: </label>
            <input type="text" placeholder="Imię" name="name"/><br>
            <input id="surname" type="text" placeholder="Nazwisko" name="surname"/><br>
            <label>Okładka: </label>
            <input type="text" placeholder="Okładka" name="cover"/><br>
            <label>Formaty: </label>
            <input type="radio" placeholder="Papierowa" name="type" value="książka"/>Papierowa<br>
            <input type="radio" placeholder="Ebook" name="type" value="e-book"/>E-book<br>
            <input type="radio" placeholder="Audiobook" name="type" value="audiobook"/>Audiobook<br>
            <label>Cena zakupu:</label>
            <input type="number" step="0.01" placeholder="Cena zakupu" name="purchasePrize"/><br>
            <label>Cena sprzedaży:</label>
            <input type="number" step="0.01" placeholder="Cena sprzedaży" name="prize"/><br>
            <label>Rabat:</label>
            <input type="number" step="0.01" placeholder="Rabat" name="discount"/><br>
            <label>Ilość:</label>
            <input type="number" placeholder="Ilość" name="quantity"/><br>
            <label>Opis: </label>
            <input type="text" placeholder="Opis" name="description"/><br>
            <label>Gatunek: </label>
            <input type="text" placeholder="Gatunek" name="genre"/><br>
            <label>Liczba stron: </label>
            <input type="number" placeholder="LiczbaStron" name="pages"/><br>
            <button id="login_button" type="submit">Dodaj książkę</button>
        </form>
    </div>
</div>

</body>
</html>