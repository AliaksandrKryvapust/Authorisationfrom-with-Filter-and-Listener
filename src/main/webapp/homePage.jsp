<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Example Registration form</title></head>
<meta charset="UTF-8">
<title>VotePage</title>
<style> p {
    size: 20px;
    text-align: center; /*text alignment*/
}

.registerClass {
    background-color: cornsilk;
    text-align: center;
}

/*set class properties, higher priority than p{}*/
</style>
<body>
<h1 class="registerClass"> Welcome at our homepage!</h1>
<h2 class="registerClass"> If you don`t have account create it using create button.<br>
    If you have one push sing in button</h2>
<p class="registerClass">
    <button onclick="location.href='${pageContext.request.contextPath}/ui/singUp'" type="button">
        Create account
    </button>
    <button onclick="location.href='${pageContext.request.contextPath}/ui/singIn'" type="button">
        Sing in
    </button>
</p>
</body>
</html>