<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><b>Settings</b></h1>
<form:form action="/update" method="post" modelAttribute="email">
    <b>Languages</b>
    <form:select path="language">
        <form:options items="${languages}"/>
    </form:select> <br>
    <b>Page Size: </b>
    Show <form:select path="pageSize">
                <form:options items="${pageSizes}"  />
            </form:select> emails per page
    <br>
    <b>Spams filter</b>
    <form:checkbox path="spamFilter" /> Enable spam filter<br>
    <b>Signature</b>
    <form:textarea path="signature" /> <br>
    <form:button>Update</form:button>
    <form:button type="reset">Cancel</form:button>
</form:form>

<h2>After Click Update</h2>
<table>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
    </tr>
    <tr>
        <td><c:out value="${email.language}" /></td>
        <td><c:out value="${email.pageSize}" /></td>
        <td><c:out value="${email.spamFilter}" /></td>
        <td><c:out value="${email.signature}" /></td>
    </tr>
</table>
</body>
</html>