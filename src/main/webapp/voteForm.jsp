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
        background-color: snow
    }

    .choice {
        background-color: mintcream
    }

    .introduction_text {
        background-color: cornsilk
    }

    /*set class properties, higher priority than p{}*/
    </style>
<body>
<form method="post" name="voting" action="${pageContext.request.contextPath}/entry_form">
    <p class="select"> <!--declaring classes to group properties-->
        HW voting form <br> <br> <br>
        Select the best singer
        <label>
            <select name="singer">
                <c:forEach items="${dataForSingers}" var="singer">
                    <option value="${singer.getId()}">${singer.getName()}</option>
                </c:forEach>
            </select>
        </label>
    <p class="choice"> Choose your favorite music genres <br>
        Only 3-5 options are allowed <br>
    <c:forEach items="${dataForGenres}" var="choice">
                    <label><input type="checkbox" name="genres" value=${choice.getId()}></label>
                    ${choice.getName()}
    </c:forEach>
</p>

    <p class="introduction_text"> Perform an introduction text about yourself <br>
        <label>
            <textarea rows="5" cols="30" name="message"></textarea>
        </label>
    </p>
    <p><input type="submit" name="submit_btn" value="Submit"></p>
</form>
<form method="get" name="voting" action="${pageContext.request.contextPath}/statistic">
    <p><input type="submit" name="submit_btn" value="Skip vote and see results"></p>

</form>
</body>
</html>