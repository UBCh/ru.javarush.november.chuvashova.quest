
<%@ page import="com.example.quest.controller.DispatherQuest.DisperserQuest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% int level= Integer.parseInt(DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(3));%>

<html>
<head>
    <title>fundament</title>
    <link href="/static/main.css" type="text/css" rel="stylesheet" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<header>
    <h2><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(0)%></h2>
</header>

<section>
    <nav>
        <ul>
            <br>
            <li>
    <form action="${pageContext.request.contextPath}/logic" method="POST">
        <label for="id_choice">сделай свой выбор:</label><br>
        <select id="id_choice" name="choice">
            <option value="wrong"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(level).get(3)%>
            </option>
            <option value="right"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(level).get(2)%>
            </option>
        </select>
        <input type="submit" id="submit" value="смело шагай=>">
    </form>
            </li>
        </ul>
    </nav>

    <article>
        <p id="id_content"><%=DisperserQuest.PAGE_CONTENT_by_LEVEL.get(level).get(0)%>        </p>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </article>
</section>

<footer>
    <h3 id="idSession">ID session : ${idSession}</h3>
    <h3 id="player_name">Player name : ${name}</h3>
    <h3 id="current_game">Current game: ${current}</h3>
  </footer>
</body>

</html>
