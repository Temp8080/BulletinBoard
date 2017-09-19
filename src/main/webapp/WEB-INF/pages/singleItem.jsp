

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item page</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
        <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
        <script src="webres/js/scripts.js" type="text/javascript"></script> 
    </head>
    <body class="singleItem">
        <div>
            <h1>Name: ${items.name}</h1>
            <img src="${items.img}"/>
            <h5>About: ${items.about}</h5>
            <h5>Category: ${items.category}</h5>
            <h5><a href="${pageContext.request.contextPath}/owner?owner=${items.owner}">
            Owner: ${items.owner}</a></h5>
            <h5>Phone to buy: ${owner.phone}</h5>
            <h3>Price: ${items.price} UAH</h3>
            <c:if test="${isLogin}">
                    <button id="addtoFav" onclick="addToFav(${items.id})">Add to favorites</button>
                </c:if>
            <hr>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/main">
                <input type="submit" value="Main page"/>
            </form>
        </div>
    </body>
</html>
