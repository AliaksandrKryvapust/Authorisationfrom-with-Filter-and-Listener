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
        <th>Active users</th>
        <th>Total registered users</th>
        <th>Total sent messages</th>
    </tr>
    <tr>
        <td>
            ${statistic.getSessionCounter()}
        </td>
        <td>
            ${statistic.getUserCounter()}
        </td>
        <td>
            ${statistic.getMessagesCounter()}
        </td>
    </tr>
</table>
<p class="registerClass">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/admin/admin'" type="button">
        Create new Admin
    </button>
</p>
</body>
</html>