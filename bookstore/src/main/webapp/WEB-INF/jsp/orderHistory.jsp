<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <table class="shopping-table">
            <%
                int i = 0;
            %>
            <c:set var="sum" value="${0}"/>
            <c:forEach items="${history}" var="item">
                <%
                    i++;
                    if (i == 1) {

                %>
                <tr>
                    <td>

                    </td>
                    <td>
                        Tytuł
                    </td>
                    <td>
                        Autorzy
                    </td>
                    <td>
                        Ilość
                    </td>
                    <td>
                        Format
                    </td>
                    <td>
                        Cena(zł)
                    </td>
                    <td>
                        Data(RRRR/MM/DD)
                    </td>
                </tr>

                <tr>
                    <%
                        }
                    %>
                    <td>
                        <img src=${item.warehouseOr.booksW.image} alt="cover"
                             onerror="this.onerror=null;this.src='https://about.canva.com/wp-content/uploads/sites/3/2015/01/art_bookcover.png';"
                             height="180" width="100">
                    </td>
                    <td>
                            ${item.warehouseOr.booksW.title}
                    </td>
                    <td>
                            ${item.warehouseOr.booksW.getFullName()}
                    </td>
                    <td>
                            ${item.quantity}
                    </td>
                    <td>
                            ${item.warehouseOr.bookFormatW.bookFormat}
                    </td>
                    <td>
                        <c:set var="price" value="${0}"/>
                        <c:set var="price"
                               value="${(item.warehouseOr.price - ((item.warehouseOr.price * item.warehouseOr.discount)/100)) * item.quantity }"/>
                        <c:set var="sum" value=" ${sum + price}"/>
                        <fmt:formatNumber value="${price}" currencySymbol="zł" type="currency"/>
                    </td>
                    <td>
                            ${item.date}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<c:if test="${error != null}">

    <script>
        alert("${error}");
    </script>
</c:if>
</body>
</html>
