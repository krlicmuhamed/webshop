<%@ page import="models.ProductsEntity" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello Products!</h2>
<h3>Vaša korpa:</h3>
<table border="1" style="border-collapse: collapse" cellpadding="8" cellspacing="0">
    <tr style='background-color:powderblue;'>
        <td>Name</td>
        <td>Price</td>
    </tr>
    <%
        List<ProductsEntity> CartItems = (List<ProductsEntity>) request.getAttribute("cartItems");

        for (ProductsEntity product : CartItems) {
    %>
    <tr>
        <td><%=product.getName()%>
        </td>
        <td><%=product.getPrice()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
