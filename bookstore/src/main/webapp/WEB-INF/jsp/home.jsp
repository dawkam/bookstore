<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import ="pl.polsl.bookstore.entity.BookAuthor" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/homePage.css">
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
    <div class="profile_button">
        <button type="submit">Profile</button>
    </div>
    <div class="profile_button">
        <button type="submit">Cart</button>
    </div>
    <div class="cart_button">
        <button onclick="location.href='/login'" type="submit">Login</button>
    </div>
</div>
<div class="left_panel">
    <div class="left_panel_contents">
        <a href="/api/authors">Wypisz Wszystkich autorów</a><br>
    </div>
</div>
<div class="main_panel">
    <div class="main_panel_contents">
        <table id="search-table">
            <%
                int i = 0;
            %>
            <tr>
                <c:forEach items="${bookList}" var="book">
                <%
                    if (i == 2) {
                %>
                <td>
                    <table id="cell">
                        <tr>
                            <td>
                                <img src=${book.image} alt="cover" height="180" width="100">
                            </td>
                            <td>
                                <table id="text">
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
                                                ${book.getPrice()}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="standard_button" type="submit">Kup</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <%
                i = 0;
            } else {
            %>
            <td>
                <table id="call2">
                    <tr>
                        <td>
                            <img src=${book.image} alt="cover" height="180" width="100">
                        </td>
                        <td>
                            <table id="text2">
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
                                            ${book.getPrice()}
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <button class="standard_button" type="submit">Kup</button>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <%
                    i += 1;
                }
            %>
            </c:forEach>
            <%
                if (i != 0) {
            %>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
