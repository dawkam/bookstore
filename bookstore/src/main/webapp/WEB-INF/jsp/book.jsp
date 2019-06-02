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
    <div class="profile_button">
        <button type="submit">Koszyk</button>
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
        <form>
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
                <input class="do_koszyka_button" type="button" value="Dodaj do koszyka">
            </select>
        </form>
    </div>
</div>
<!-- begin wwww.htmlcommentbox.com -->
<div id="HCB_comment_box"><a href="http://www.htmlcommentbox.com">Comment Form</a> is loading comments...</div>
<link rel="stylesheet" type="text/css" href="https://www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
<script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=hcb_user.PAGE || (""+window.location).replace(/'/g,"%27"), h="https://www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&opts=16862&num=10&ts=1559488616396");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>
<!-- end www.htmlcommentbox.com -->

<script>
    function myFunction(){
        var selectBox = document.getElementById("selectBox");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;
        if(selectedValue === "papier")
            document.getElementById("cena").innerHTML = "Cena: ${bookPricePaper} zł";
        else if(selectedValue === "ebook")
            document.getElementById("cena").innerHTML = "Cena: ${bookPriceEbook} zł";
        else if(selectedValue === "audiobook")
            document.getElementById("cena").innerHTML = "Cena: ${bookPriceAudiobook} zł";
        else
            document.getElementById("cena").innerHTML = "hmmmm";
    }
</script>
</body>
</html>
