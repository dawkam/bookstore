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
            <button type="submit">Profil</button>
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

            </td>
            </tr>

            <tr>
                <c:forEach items="${user.shoppingCart}" var="item">

                            <td>
                                <img src=${item.warehouseSh.booksW.image} alt="cover" height="180" width="100">
                            </td>
                            <td>
                                    ${item.warehouseSh.booksW.title}
                            </td>
                            <td>
                                    ${item.warehouseSh.booksW.getFullName()}
                            </td>
                            <td>
                                <form method="POST" action="/shoppingcart">
                                    <input type="number" name="quantity" class="quantity" value="${item.quantity}" min="1" max="999">
                                    <br>
                                    <input type="hidden" name="idWarehouse" value="${item.warehouseSh.idBookWarehouse}">
                                    <button onclick="" type="submit">Zmień</button>
                                </form>
                            </td>
                            <td>
                                    ${item.warehouseSh.bookFormatW.bookFormat}
                            </td>
                            <td>

                                    ${item.warehouseSh.price}
                            </td>
                             <td>
                             <form class="delete">
                                 <button onclick="location.href='/shoppingCart'" type="submit">Usuń</button>
                             </form>
                            </td>
                        </tr>
            </c:forEach>
        </table>



    </div>
</div>
</body>
</html>
