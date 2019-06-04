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
        <table>
            <tr>
                <td  class="profitable">
                    <table class="shopping-table">
                        <tr>
                            <td>
                                Rok
                            </td>
                            <td>
                                Miesiąc
                            </td>
                            <td>
                                Zysk(zł)
                            </td>
                        </tr>
                        <c:forEach items="${profitPerMonth}" var="item">
                            <%

                            %>
                            <tr>

                                <td>
                                        ${item.getYear()}
                                </td>
                                <td>
                                        ${item.getMonth()}
                                </td>
                                <td>
                                        ${item.getProfit()}
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </td>
                <td class="profitable">
                    <table class="shopping-table">
                        <tr>
                            <td>
                                Tytuł
                            </td>
                            <td>
                                Zysk
                            </td>
                        </tr>
                        <c:forEach items="${profitPerBook}" var="book">
                            <%

                            %>
                            <tr>

                                <td>
                                        ${book.getTitle()}
                                </td>
                                <td>
                                        ${book.getProfit()}
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                <td class="profitable">
                    <table class="shopping-table">
                        <tr>
                            <td>
                                Autor

                            </td>
                            <td>
                                Zysk
                            </td>
                        </tr>
                        <c:forEach items="${profitPerAuthor}" var="author">
                            <%

                            %>
                            <tr>

                                <td>
                                        ${author.getFirstName()}&nbsp ${author.getSurname()}
                                </td>
                                <td>
                                        ${author.getProfit()}
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </td>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
