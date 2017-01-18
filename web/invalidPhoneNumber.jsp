<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DonBusLine</title>
    <link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Введите корректный номер телефона</h2>
<form method="POST" action="${path}/index"/>
    <table border ="0"><tr><td valign="top">
        Ваше имя:</td> <td valign="top">
        <input type="text" name="name" size="20">
    </td></tr><tr><td valign="top">
        Телефон: </td> <td valign="top">
        <input type="text" name="phone" size="20">
    </td></tr><tr><td valign="top">
        <input type="submit" value="Отправить"></td></tr>
    </table></form>
</body>
</html>
