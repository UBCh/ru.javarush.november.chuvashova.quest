<%@ page import="quest.repositories.contents.ContentQuest" %>
<%@ page import="quest.controller.DispatherQuest.DisperserQuest" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
        <p id="id_victory"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(2)%>
        </p>
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
