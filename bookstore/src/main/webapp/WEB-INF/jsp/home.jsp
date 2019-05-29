<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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
            <label>Book search</label>
            <input type="text" placeholder="Search.." name="bookName"/>
            <button class="standard_button" type="submit">Szukaj</button>
        </form>
    </div>
    <c:if test="${user != null}">
        <div class="profile_button">
            <button type="submit">Profile</button>
        </div>
    </c:if>
    <div class="cart_button">
        <button onclick="location.href='/shoppingCart'" type="submit">Cart</button>
    </div>
    <c:if test="${user == null}">
        <div class="profile_button">
            <button onclick="location.href='/login'" type="submit">Login</button>
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
<div class="left_panel">
    <div class="left_panel_contents">
        <label class="side_label">Sortuj:</label>
        <form method="GET" action="/home">
            <button class="side_button" type="submit">Autor (a-z)</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Autor (z-a)</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Tytul (a-z)</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Tytul (z-a)</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Cena najniżej</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Cena najwyżej</button>
        </form>
        <label class="side_label">Filtruj:</label>
        <form method="GET" action="/home">
            <button class="side_button">Cena najwyżej</button>
        </form>
        <form method="GET" action="/home">
            <button class="side_button">Cena najwyżej</button>
        </form>
    </div>
</div>
<div class="main_panel">
    <div class="main_panel_contents">
        <table class="search-table">
            <%
                int i = 0;
            %>
            <tr>
                <c:forEach items="${bookList}" var="book">
                <%
                    i++;
                %>
                <td>
                    <table>
                        <tr>
                            <td>
                                <img src=${book.image} alt="cover" height="180" width="100">
                            </td>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                                ${book.title}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                                ${book.getFullName()}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="buy_button"><i class='fas fa-cart-plus'></i></button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
                <%
                    if (i % 3 == 0) {

                %>
            </tr>
            <tr>
                <%
                    }
                %>
                </c:forEach>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
