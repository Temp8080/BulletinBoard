<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body onload="redirectTimeOut('${pageContext.request.contextPath}/main');">
<h1 class="info-h1">${info}</h1>


<form class="info-form-main-btn" action="${pageContext.request.contextPath}/main">
    <input type="submit" value="Main"/>
</form>
<form class="info-form-redirect-timer">
    Redirecting to Main Page in <span id="countdown">5</span>.
</form>
</body>
</html>