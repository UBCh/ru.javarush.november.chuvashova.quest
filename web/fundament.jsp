<%@ page import="quest.repositories.contents.ContentQuest" %>
<%@ page import="quest.controller.DispatherQuest.DisperserQuest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int level = Integer.parseInt(DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(3));
   level=level+1;
   DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).set(3, String.valueOf(level));
%>
<!DOCTYPE html>
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
                <%@ include file="/choice.jsp" %>
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
