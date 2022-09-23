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

    .registerClass {
        background-color: cornsilk
    }

    /*set class properties, higher priority than p{}*/
    </style>
<body>
<form method="post" name="register" action="${pageContext.request.contextPath}/api/admin/newAdmin">
    <p class="registerClass"> You need to fulfill login form below <br>
        login <br>
        <label>
            <textarea rows="1" cols="20" name="login"></textarea>
        </label> <br>
        password <br>
        <label>
            <textarea rows="1" cols="20" name="password"></textarea>
        </label> <br>
    </p>
    <p><input type="submit" name="submit_btn" value="Submit"></p>
</form>
</body>
</html>