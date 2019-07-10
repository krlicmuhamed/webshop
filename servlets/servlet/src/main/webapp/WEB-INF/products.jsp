<%@ page import="models.ProductsEntity" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello Products!</h2>
<h3>Raspoloživi proizvodi</h3>
<table border="1" style="border-collapse: collapse" cellpadding="8" cellspacing="0">
    <tr style='background-color:powderblue;'><td>Name</td><td>Price</td><td></td></tr>
    <%
        List<ProductsEntity> productList = (List<ProductsEntity>) request.getAttribute("products");
        for (ProductsEntity product : productList) {
    %>
    <tr>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td>
            <form action="cart/add" method="POST">
                <input name="quantity" type="number" size="3">
                <input type="submit" value="Dodaj">
                <input name="productId" type="hidden" value="<%=product.getId()%>">
            </form>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
