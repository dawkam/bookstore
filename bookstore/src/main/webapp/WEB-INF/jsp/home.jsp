<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/homePage.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="top_panel">
    <div class="logo">
        <img src="/logo.png" alt="logo" height="94" class="logo" onclick="location.href='/profile'">
    </div>
    <div class="search_bar">
        <form method="GET" action="/">
            <label>Book search</label>
            <input type="text" placeholder="Search.." name="bookName"/>
            <button type="submit">Szukaj</button>
        </form>
    </div>
    <div class="profile_button">
        <button type="submit">Profile</button>
    </div>
    <div class="cart_button">
        <button type="submit">Cart</button>
    </div>
</div>
<div class="left_panel">
    <div class="left_panel_contents">
        <a href="/api/authors">Wypisz Wszystkich autorów</a><br>
    </div>
</div>
<div class="main_panel">
    <div class="main_panel_contents">
        <c:forEach items="${bookAuthorList}" var="bookAuthor">
                ${bookAuthor.booksB.title} by ${bookAuthor.authorsB.firstName} ${bookAuthor.authorsB.surname}<br>
        </c:forEach>
    </div>
</div>
</body>
</html>
