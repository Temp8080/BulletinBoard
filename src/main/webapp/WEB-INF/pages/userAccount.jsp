<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css"
          href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
    <title>My Account</title>
</head>
<body>
<div>
    <h1 align="center">Welcome: ${user.login}</h1>

</div>
<div>
    <form action="${pageContext.request.contextPath}/main" class="form-startpage">
        <input type="submit" value="Main Page">
    </form>
</div>
<div class="useracc-fav-items-div">
    <c:choose>
        <c:when test="${empty items}">
            Your favorites is empty
        </c:when>
        <c:otherwise>
            <h1 id="label-of-list">Item:</h1>
            <hr>
            <c:forEach items="${items}" var="i">
                <div id="item${i.id}">
                    <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                        <h1>Name: ${i.name}</h1>
                        <img src="${i.smallimg}"/>
                    </a>
                    <h5>About: ${i.about}</h5>
                    <h5>Category: ${i.category}</h5>
                    <h5>Owner: ${i.owner}</h5>
                    <h3>Price: ${i.price} UAH</h3>
                    <button value='delete from favorites' onclick="deleteFromFavorits(${i.id})">удалить</button>
                    <hr>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
<script type="text/javascript">
    var itemsCount = ${items.size()};
    var label = document.getElementById("label-of-list");
    function deleteFromFavorits(id) {
        if (--itemsCount < 1) label.innerHTML = "Your favorites is empty";
        var item = document.getElementById("item" + id);
        item.remove();
        console.log(id);
        var request = "id=-" + id;
        console.log(request);
        fetch('${pageContext.request.contextPath}/userAccount', {
            method: 'POST',
            headers: {
                'Accept': 'application/json, application/xml, text/plain, text/html,',
                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: request
        }).catch(alert);
    }
</script>
</body>
</html>
