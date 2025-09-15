<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>The condiments that sandwich have are: </h2>
    <ul>
        <c:forEach var="c" items="${condiment}">
        <li>
            ${c}
        </li>
        </c:forEach>
    </ul>
<a href="/">Back</a>
</body>
</html>
