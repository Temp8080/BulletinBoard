<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new Item</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value='${pageContext.request.contextPath}/webres/css/style.css'/>">
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <h1 align="center">Enter info about your item:</h1>
        </div>
        <div id="create-div">
            <form action="create" class="creation-form"> 
                    <table>
                        <tr><td>Enter name:</td><td>     <input name="name"/></td></tr><br>
                        <tr><td>Enter about:</td><td>    <input name="about"/></td></tr><br>
                        <tr><td>Enter price:</td><td>    <input name="price"/></td></tr><br>
                        <tr><td>Enter img:</td><td>      <input name="img"/></td><td>link(http://)</td></tr><br>
                        <tr><td>Enter smallimg:</td><td> <input name="smallimg"/></td><td>link(http://)</td></tr><br>
                        <tr><td>Enter category:</td><td> <select name="category">
                                    <option>proc</option>
                                    <option>mb</option>
                                </select></td></tr><br>
                        <tr><td colspan="2"><input type="submit" value="Create" id="create-input-submit"/></td></tr>
                    </table>  

            </form>
            
        </div>
        <a href="${pageContext.request.contextPath}/main" class="create-ahref-main-btn">
                <input type="submit" value="Main"/>
            </a>
    </body>
</html>
