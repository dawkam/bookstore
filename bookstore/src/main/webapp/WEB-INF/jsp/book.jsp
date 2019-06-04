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
<body onload="myFunction()">
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
    <c:if test="${user.getRoleU().getIdRole() == 2}">
        <div class="profile_button">
            <button id="addBookButton" onclick="location.href='/newBook'" type="submit">Dodaj Książkę</button>
        </div>
        <div class="raports_button">
            <button id="profitButton" onclick="location.href='/profit'" type="submit">Raport</button>
        </div>
    </c:if>
    <div class="cart_button">
        <button onclick="location.href='/shoppingCart'" type="submit">Koszyk</button>
    </div>
    <c:if test="${user == null}">
        <div class="cart_button">
            <button onclick="location.href='/login'" type="submit">Zaloguj</button>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="cart_button">
            <form method="POST" action="/logout">
                <button type="submit">Wyloguj</button>
            </form>
        </div>
    </c:if>
</div>
<div id="book_img_div">
    <img src=${bookSelected.image} alt="cover" height="360" width="200">
    <div id="book_info">
        Autor: ${bookSelected.getFullName()}<br>
        Tytuł: ${bookSelected.title}<br>
        <span id="cena"></span><br>
        <form method="GET" action="/shoppingCart">
            <select name="formatKsiazki" class="typ_ksiazki" id="selectBox" onchange="myFunction()">
                <c:if test="${paperFormat != null}">
                    <option class="typ_ksiazki" value="papier">Papierowy</option>
                </c:if>
                <c:if test="${eBookFormat != null}">
                    <option class="typ_ksiazki" value="ebook">E-book</option>
                </c:if>
                <c:if test="${audiobookFormat != null}">
                    <option class="typ_ksiazki" value="audiobook">Audiobook</option>
                </c:if>
                <c:if test="${paperFormat != null}">
                    <input type="hidden" name="warehouseidPaper" value=${warehousePaper}>
                </c:if>
                <c:if test="${eBookFormat != null}">
                    <input type="hidden" name="warehouseidEbook" value=${warehouseEbook}>
                </c:if>
                <c:if test="${audiobookFormat != null}">
                    <input type="hidden" name="warehouseidAudiobook" value=${warehouseAudiobook}>
                </c:if>
                <input class="do_koszyka_button" type="submit" value="Dodaj do koszyka">
            </select>
        </form>
    </div>
</div>
<div id="comment_section">
    <c:if test="${user != null}">
    <form method="GET" action="/comment">
        <input id="comment" type="text" maxlength="1000" value="${userOpinion}" name="opinion"><br>
        <input type="hidden" name="bookID" value="${bookSelected.idBook}">
        <button id="commentButton" class="commitComment" type="submit">Zakomentuj</button>
    </form>
    </c:if>
    <table class="comments">
        <c:forEach items="${bookSelected.getOpinions()}" var="comment">
            <tr>
                <td>
                    ${comment.getUsersO().getLogin()}:<br>
                    ${comment.opinion}
                        <c:if test="${user != null}">
                            <form method="GET" action="/report">
                                <input type="hidden" name="bookId" value="${comment.booksO.idBook}">
                                <input type="hidden" name="userId" value="${comment.usersO.idUser}">
                                <button id="reportButton" class="report" type="submit">Zreportuj</button>
                            </form>
                        </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    function myFunction() {
        var selectBox = document.getElementById("selectBox");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        if (selectedValue === "papier")
            document.getElementById("cena").innerHTML = "Cena: ${bookPricePaper} zł";
        else if (selectedValue === "ebook")
            document.getElementById("cena").innerHTML = "Cena: ${bookPriceEbook} zł";
        else if (selectedValue === "audiobook")
            document.getElementById("cena").innerHTML = "Cena: ${bookPriceAudiobook} zł";
        else
            document.getElementById("cena").innerHTML = "hmmmm";
    }
</script>
</body>
</html>
