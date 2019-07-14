<%@ page import="models.ProductsEntity" %>
<%@ page import="java.util.List" %>
<%
    boolean userStatus = (boolean) session.getAttribute("user.loggedIn");
%>
<html>
<head>
    <meta contentType="text/html; charset="UTF-8"/>
</head>
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
        <td>Option</td>
    </tr>
    <%
        List<ProductsEntity> CartItems = (List<ProductsEntity>) request.getAttribute("cart.items");
        Double productsTotal = (Double) request.getAttribute("cart.total");
        int itemIndex = 0;
        for (ProductsEntity product : CartItems) {
    %>
    <tr>
        <td><%=product.getName()%>
        </td>
        <td><%=product.getPrice()%>
        </td>
        <td>
            <form action="/cart/remove" method="POST">
                <input name="itemId" type="hidden" value="<%=itemIndex++%>">
                <button type="submit">Remove</button>
            </form>
        </td>
    </tr>
    <%}%>
    <tr>
        <td></td>
        <td>Total:</td>
        <td><%= productsTotal %></td>
    </tr>
</table>
<form action="/cart/order" method="POST">
    <button type="submit">Order</button>
</form>
</body>
</html>
