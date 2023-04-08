
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>QUEST</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/start" method="POST">
    <label for="id_choice">выбери свой квест:</label><br>
    <select id="id_choice" name="choice">
        <option value="BD_QUEST">приключения</option>
        <option value="BD_QUEST2">психология</option>
        <option value="BD_QUEST3">юмор</option>
    </select>
    <input type="submit" id="submit" value="нажимай сюда , если решение принято"></form>
</body>
</html>

