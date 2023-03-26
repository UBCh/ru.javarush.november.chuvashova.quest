<%@ page import="quest.repositories.Content" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>fail</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <img style="width: auto; height: auto;  opacity: 0.3;" src='${pageContext.request.contextPath}/img/paniс.jpg'>
    <section style="position:absolute;top: 30%;  text-align: center; ">
        <p style="font-size: 75px;" id="id_error">БЕЗ ПАНИКИ, что то пошло не так, просто начни с начала</p>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%@ include file="/reStart.jsp" %>
    </section>
</div>
</body>
</html>
