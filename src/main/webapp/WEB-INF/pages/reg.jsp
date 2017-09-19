<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/register" onsubmit="return validateForm()" method="POST" class="register-form" >
            <table>
            <tr><td>Login:</td><td> <input type="text" name="login"/></td></tr><br>
            <tr><td>Password:</td><td> <input type="password" name="pass"/></td></tr><br>
            <tr><td>Phone:</td><td> <input onkeypress="return isNumberKey(event)" type="number" name="phone"/></td></tr><br>
            <tr><td colspan="2"><input type="submit" value="Register" id="register-form-input-register"/></td></tr>
            </table>
        </form><hr>
        <form action="${pageContext.request.contextPath}/main" class="register-form-startpage">
            <input type="submit" value="Start Page"/>
        </form>
    </body>
</html>