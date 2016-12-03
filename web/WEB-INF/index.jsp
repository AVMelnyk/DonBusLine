<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Don-BusLine</title>
</head>
<body>
<h2>Пожалуйста, введите ваши данные. Мы вам перезвоним.</h2>
<form method="POST" action="${path}/"/>
<table border ="0"><tr><td valign="top">
    Ваше имя:</td> <td valign="top">
    <input type="text" name="name" size="20">
    </td></tr><tr><td valign="top">
    Телефон: </td> <td valign="top">
    <input type="text" name="phone" size="20">
    </td></tr><tr><td valign="top">
    <input type="submit" value="Отправить"></td></tr>
    </table></form>
<p></p>
</body>
</html>