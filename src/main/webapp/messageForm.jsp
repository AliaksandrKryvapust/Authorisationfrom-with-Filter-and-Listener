<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    .messageClass {
        background-color: cornsilk
    }

    /*set class properties, higher priority than p{}*/
    </style>
<body>
<p class="messageClass ">
    Write a message <br> <br>

<form method="post" name="login" action="${pageContext.request.contextPath}/api/message">
    <p class="loginClass">
        Write a message to User <br>
        User
        <label>
            <textarea rows="1" cols="20" name="destination"></textarea>
        </label> <br>
        message <br>
        <label>
            <textarea rows="3" cols="30" name="message"></textarea>
        </label> <br>
    <p><input type="submit" name="submit_btn" value="Send message"></p>
</form>
<p class="registerClass">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/user/chats'" type="button">
        Go to chat room
    </button>
    <c:if test="${sessionScope.button}">
        <button onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistic'" type="button">
            Statistic for Admin
        </button>
    </c:if>
</p>
</body>
</html>