<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main page</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">

    <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div class="main-control-menu">
    <div>
        <c:if test="${!isLogin}">
            <form action="${pageContext.request.contextPath}/register">
                <input type="submit" value="Register"/>
            </form>
        </c:if>
        <c:if test="${isLogin}">

            <a href="${pageContext.request.contextPath}/create">
                <input type="submit" value="Create new item"/>
            </a>
            <form action="${pageContext.request.contextPath}/userAccount">
                <input type='submit' value='My Account'/>
            </form>

            <hr>
            <div>
                <h3>Filters:</h3>
                <form action="main">
                    Select category:<select name="category">
                    <option>all</option>
                    <option>mb</option>
                    <option>proc</option>
                </select><br>
                    Enter login:<input name="login"/>
                    <input type="submit" value="Accept"/>
                </form>

            </div>
            <hr>
            <a class="a-exit" href="${pageContext.request.contextPath}/login?exit=true">
                <input type="submit" value="Exit"/>
            </a>
        </c:if>
    </div>
    <div>
        <c:if test="${!isLogin}">
            <form action="${pageContext.request.contextPath}/login">
                <input type="submit" value="Log In"/>
            </form>
        </c:if>
    </div>
</div>
<div>
    <h1>Items:</h1>
    <hr>
    <c:forEach items="${items}" var="i">
        <table>
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                        <h1>${i.name}</h1>
                        <img src="${i.img}"/>
                        <h5>${i.about}</h5>
                        <h3>Price: ${i.price} UAH</h3>
                    </a>
                    <h5><a href="${pageContext.request.contextPath}/owner?owner=${i.owner}">
                        Owner: ${i.owner}
                    </a></h5>
                </td>
            </tr>
        </table>
        <c:if test="${isLogin}">
            <button id="addtoFav" onclick="addToFav(${i.id})">Add to favorites</button>
        </c:if>
        <hr>
    </c:forEach>
</div>
</body>
</html>
