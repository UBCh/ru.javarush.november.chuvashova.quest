<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>reStart</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<button type="button" id="reStart_button" onclick="window.location=<%="'/index.jsp'"%>">reincarnation</button>
</body>
</html>