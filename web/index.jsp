<%@ page import="quest.repositories.Content" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>$Title$</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<%
    request.setAttribute("Request-Attribute", "Value of Attribute ");
    RequestDispatcher rd = request.getRequestDispatcher("/start");
    rd.forward(request, response);
%>
</body>
</html>