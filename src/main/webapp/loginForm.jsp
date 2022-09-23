<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VotePage</title>
    <style> p {
        size: 20px;
        text-align: center; /*text alignment*/
    }

    .select {
        background-color: cornsilk
    }

    /*set class properties, higher priority than p{}*/
    </style>
<body>
<form method="post" name="login" action="${pageContext.request.contextPath}/api/login">
    <p class="loginClass"> Login form <br> Enter your login and password <br>
        login <br>
        <label>
            <textarea rows="1" cols="20" name="login"></textarea>
        </label> <br>
        password <br>
        <label>
            <textarea rows="1" cols="20" name="password"></textarea>
        </label> <br>
    <p><input type="submit" name="submit_btn" value="Submit"></p>
</form>
<p class="select">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/singUp'" type="button">
        Don`t have an account? Proceed with registration form
    </button>
</p>
</body>
</html>