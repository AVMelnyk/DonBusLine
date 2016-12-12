<%@ page import="com.melnyk.CallbackModel "%>
<link rel="stylesheet" type ="text/css" href="styles/main.css"/>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Don-BusLine</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% String name =request.getParameter("name"); %>
    <% String phone =request.getParameter("phone");%>
    <% new CallbackModel(name, phone).notifyRecipient(); %>
    <h2>Ожидайте, мы вам перезвоним <%=request.getParameter("name") %>.</h2>
<p></p>
</body>
</html>