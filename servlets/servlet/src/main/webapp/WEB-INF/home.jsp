<%
    boolean userStatus = (boolean) session.getAttribute("user.loggedIn");
%>
<html>
<body>
<h2>Hello Home!</h2>
<a href="/products">Products</a>
<a href="/cart">My Cart</a>
<% if(userStatus) { %>
<a href="/user/logout">Logout</a>
<% } else { %>
<a href="/user/login">Login</a>
<% } %>
</body>
</html>
