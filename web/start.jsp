<%@ page import="quest.repositories.contents.ContentQuest" %>
<%@ page import="quest.repositories.dispather.DispatcherRepository" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="quest.controller.DispatherQuest.DisperserQuest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

%>
<!DOCTYPE html>
<html>
<head>
    <title>START</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<img src='${pageContext.request.contextPath}/img/images.jpg' alt="pyramid">
<section style="position:absolute; top: 1%; text-align: center;">
    <h1 style="text-align:center;"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(0)%>
    </h1>
    <p><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(1)%>
    </p>
    <hr>
    <form action="${pageContext.request.contextPath}/init" method="POST" id="action" accept-charset="windows-1251">
        <label for="lname" >как зовут тебя, мой юный друг?:</label><br>
        <input type="text" id="lname" name="lname" value=""><br><br>
        <input type="submit" id="submit" value="вперед, навстречу приключениям=>">
    </form>
</section>
</div>
</body>
</html>