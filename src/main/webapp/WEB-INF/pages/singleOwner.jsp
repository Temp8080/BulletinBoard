<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Owner Page</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
</head>
<body>
<div>
    <h1>Owner: ${user.login}</h1><br>
    <h1>Contact Phone: ${user.phone}</h1>
    <form action="${pageContext.request.contextPath}/main" class="form-startpage">
        <input type="submit" value="Start Page"/>
    </form>
</div>
<hr>
<div>
    <h1>Owner Items:</h1>
    <hr>
    <div class="single-owner-items-div">
        <c:forEach items="${items}" var="i">
            <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                <h1>Name: ${i.name}</h1>
                <img src="${i.smallimg}"/>
            </a>
            <h5>About: ${i.about}</h5>
            <h5>Category: ${i.category}</h5>
            <h3>Price: ${i.price} UAH</h3>
            <hr>
        </c:forEach>
    </div>
</div>
</body>
</html>
