<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="/show">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
    <input type="checkbox" name="condiment" value="Tomato"> Tomato
    <input type="checkbox" name="condiment" value="Mustard"> Mustard
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>