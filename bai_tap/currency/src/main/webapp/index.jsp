<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form action="convert" method="post">
    Tỉ giá (1 USD = ? VND): <input type="text" name="rate"/><br/><br/>
    Nhập số USD: <input type="text" name="usd"/><br/><br/>
    <input type="submit" value="Convert"/>
</form>
</body>
</html>
