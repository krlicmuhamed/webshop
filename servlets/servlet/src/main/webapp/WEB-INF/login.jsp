<html>
<head>
    <meta contentType="text/html; charset="UTF-8"/>
</head>
<body>
<h2>Hello please login</h2>
<a href="/">Home</a>
<a href="/products">Products</a>
<a href="/cart">My Cart</a>
<%
    String message = (String) request.getAttribute("message");
%>
<%= message %>
<form action="/user/login" method="POST">
    <label for="email">Email</label>
    <input name="email" id="email" type="email">
    <label for="password">Password</label>
    <input name="password" id="password" type="password">
    <button type="submit">Login</button>
</form>
</body>
</html>
