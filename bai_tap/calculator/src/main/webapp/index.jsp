<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit" name="method" value="Addition">Addition(+)</button>
    <button type="submit" name="method" value="Subtraction">Subtraction(-)</button>
    <button type="submit" name="method" value="Multiplication">Multiplication(x)</button>
    <button type="submit" name="method" value="Division">Division(/)</button>
</form>

<c:if test="${not empty addition}">
    <p>Result Addition: ${addition}</p>
</c:if>

<c:if test="${not empty subtraction}">
    <p>Result Subtraction: ${subtraction}</p>
</c:if>

<c:if test="${not empty multiplication}">
    <p>Result Multiplication: ${multiplication}</p>
</c:if>

<c:if test="${not empty division}">
    <p>Result Division: ${division}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>