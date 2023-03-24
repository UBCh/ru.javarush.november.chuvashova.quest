<%@ page import="quest.repositories.Content" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>fail</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <img src='${pageContext.request.contextPath}/img/istock.jpg'>
    <section style="position:absolute;top: 10%;text-align: center; width: 60%; height: auto;">
        <p id="id_victory"><%=Content.getVictoryText()%></p>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        </section>
    <%@ include file="/reStart.jsp" %>
    </div>
</body>
</html>
