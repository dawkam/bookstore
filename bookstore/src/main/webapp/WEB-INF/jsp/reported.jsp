<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ReportedComments</title>
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
    <c:if test="${user != null}">
        <div class="profile_button">
            <button onclick="location.href='/profile'" type="submit">Profil</button>
        </div>
    </c:if>
    <div class="cart_button">
        <button onclick="location.href='/shoppingCart'" type="submit">Koszyk</button>
    </div>
    <c:if test="${user == null}">
        <div class="profile_button">
            <button onclick="location.href='/login'" type="submit">Zaloguj</button>
        </div>
    </c:if>
    <c:if test="${user.getRoleU().getIdRole() == 2}">
        <div class="profile_button">
            <button id="addBookButton" onclick="location.href='/newBook'" type="submit">Dodaj Książkę</button>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="profile_button">
            <form method="POST" action="/logout">
                <button type="submit">Wyloguj</button>
            </form>
        </div>
    </c:if>
</div>
<table class="comments">
    <c:forEach items="${opinions}" var="comment">
        <tr>
            <td>
                    Zreportowyn: ${comment.getReported()}  Użytkownik: ${comment.getUsersO().getLogin()}:<br>
                    ${comment.opinion}
                    <form method="GET" action="/block">
                        <input type="hidden" name="userId" value="${comment.usersO.idUser}">
                        <button id="blockButton" class="block" type="submit">Zablokuj</button>
                    </form>
                    <form method="GET" action="/deleteComment">
                        <input type="hidden" name="userId" value="${comment.usersO.idUser}">
                        <input type="hidden" name="bookId" value="${comment.booksO.idBook}">
                        <button id="deleteButton" class="delete" type="submit">Usuń komentarz</button>
                    </form>
            </td>
        </tr>
    </c:forEach>
</table>