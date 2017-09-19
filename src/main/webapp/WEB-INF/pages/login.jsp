<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
    </head>
    <body class="loginpage">
        <form action="${pageContext.request.contextPath}/login" method="POST" class="login-form">
            <table>
                <tr><td>Login:</td><td><input type="text" name="login"/><br></td> </tr>
                <tr><td>Password:</td><td><input type="password" name="pass"/></td> </tr><br>
                <tr><td colspan="2"><input type="submit" value="Log In" id="login-form-input-LogIn"/></td></tr> 
            </table>
        </form><hr>
        <div class="login-div-form">
            <table>
                <tr>
                    New Client? Please 
                <form action="${pageContext.request.contextPath}/register">
                    <input type="submit" value="Register"/>
                </form>
                </tr>
                <tr>
                    , or leave to
                <form action="${pageContext.request.contextPath}/main">
                    <input type="submit" value="Start Page"/>
                </form>
                </tr>
            </table>
        </div>
    </body>
</html>