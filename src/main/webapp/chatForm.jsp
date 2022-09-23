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
    Message list <br> <br>
<table>
    <tr>
        <th>Date</th>
        <th>From</th>
        <th>Message</th>
    </tr>
    <c:forEach items="${messageData}" var="message">
        <tr>
            <td>
                <fmt:parseDate value="${message.getDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
                               type="both"/>
                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/>
            </td>
            <td>
                <c:out value="${message.getAuthor()}"/>
            </td>
            <td>
                <c:out value="${message.getMessage()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<p class="registerClass">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/user/message'" type="button">
        Write a message
    </button>
    <button onclick="location.href='${pageContext.request.contextPath}/ui/logOut'" type="button">
        LogOut
    </button>
</p>
</body>
</html>