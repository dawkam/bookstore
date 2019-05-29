<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/shoppingCart.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="top_panel">
    <div class="logo">
        <img src="/logo.png" alt="logo" height="94" class="logo" onclick="location.href='/home'">
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

<div class="main_panel">
    <div class="main_panel_contents">
        <table class="search-table">
            <%
                int i = 0;
            %>
            <tr>
                <c:forEach items="${shoppingCart}" var="book">
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
                                    ${book.title}
                            </td>
                            <td>
                                    ${book.getFullName()}
                            </td>
                            <td>
                                <form>
                                    <input type="number" name="quantity" min="1" max="999">
                                </form>
                            </td>
                            <td>
                                    ${book.value}
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
