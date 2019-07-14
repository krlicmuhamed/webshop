<%
    boolean userStatus = (boolean) session.getAttribute("user.loggedIn");
//    boolean userIsAdmin = (boolean) session.getAttribute("user.isAdmin");
%>
<html>
<head>
    <meta contentType="text/html; charset="UTF-8"/>
</head>
<body>
<h2>Hello Home!</h2>
<a href="/products">Products</a>
<a href="/cart">My Cart</a>
<% if (userStatus) { %>
<%--<% if (userIsAdmin) { %> <a href="/admin">Admin Panel</a> <%}%>--%>
<a href="/user/logout">Logout</a>
<% } else { %>
<a href="/user/login">Login</a>
<% } %>
</body>
</html>
