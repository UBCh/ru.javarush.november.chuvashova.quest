<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="static quest.repositories.Content.*" %>
<%@ page import="quest.repositories.Content" %>
<html>
<head>
    <title>choice</title>
    <link href="/static/main.css" type="text/css" rel="stylesheet"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/logic" method="POST">
    <label for="id_choice">сделай свой выбор:</label><br>
    <select id="id_choice" name="choice">
        <option value="wrong"><%=Content.buttonWong.get(getLevel())%>
        </option>
        <option value="right"><%=Content.rightButton.get(getLevel())%>
        </option>
    </select>
    <input type="submit" id="submit" value="смело шагай=>">
</form>
</body>
</html>
