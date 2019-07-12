<%@ page import="models.ProductsEntity" %>
<%@ page import="java.util.List" %>
<%
    boolean userStatus = (boolean) session.getAttribute("user.loggedIn");
%>
<html>
<body>
<h2>Hello Cart!</h2>
<a href="/">Home</a>
<a href="/products">Products</a>
<% if(userStatus) { %>
<a href="/user/logout">Logout</a>
<% } else { %>
<a href="/user/login">Login</a>
<% } %>
<h3>Vaša korpa:</h3>
<table border="1" style="border-collapse: collapse" cellpadding="8" cellspacing="0">
    <tr style='background-color:powderblue;'>
        <td>Name</td>
        <td>Price</td>
    </tr>
    <%
        List<ProductsEntity> CartItems = (List<ProductsEntity>) request.getAttribute("cart.items");
        Double productsTotal = (Double) request.getAttribute("cart.total");
        for (ProductsEntity product : CartItems) {
    %>
    <tr>
        <td><%=product.getName()%>
        </td>
        <td><%=product.getPrice()%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td>Total:</td>
        <td><%= productsTotal %></td>
    </tr>
</table>
<form action="/cart/order" method="POST">
    <button type="submit">Order</button>
</form>
</body>
</html>
