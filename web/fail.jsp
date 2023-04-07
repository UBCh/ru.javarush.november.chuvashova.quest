<%@ page import="quest.controller.DispatherQuest.DisperserQuest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int level= Integer.parseInt(DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(3))-1;%>
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
    <img style="width: 1890px; height: auto;  opacity: 0.3;" src='${pageContext.request.contextPath}/img/fail.jpg'>
    <section style="position:absolute;top: 30%;  text-align: center; ">
        <p style="font-size: 75px;" id="id_fail"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(level).get(1)%>
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
        <%@ include file="/reStart.jsp" %>
    </section>
</div>
</body>
</html>
