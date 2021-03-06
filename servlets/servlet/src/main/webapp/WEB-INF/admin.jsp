<%@ page import="java.util.ArrayList" %>
<%
    ArrayList ordersList = (ArrayList) request.getAttribute("orders");
//
//    boolean userStatus = (boolean) session.getAttribute("user.loggedIn");
//    boolean userIsAdmin = (boolean) session.getAttribute("user.isAdmin");
%>
<html>
<head>
    <meta contentType="text/html; charset="UTF-8"/>
</head>
<body>
<h2>Hello Admin!</h2>
<%--<a href="/products">Products</a>--%>
<%--<a href="/cart">My Cart</a>--%>
<%--<% if(userStatus) { %>--%>
<%--<a href="/user/logout">Logout</a>--%>
<%--<% } else { %>--%>
<%--<a href="/user/login">Login</a>--%>
<%--<% } %>--%>
<h3>Trenutne narudžbe</h3>
<table border="1" style="border-collapse: collapse" cellpadding="8" cellspacing="0">
    <tr style='background-color:powderblue;'>
        <td>Cart Number</td>
        <td>Product</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Address</td>
        <td>Options</td>
    </tr>
    <%
        for (Object order : ordersList) {
            Object[] fields = (Object[]) order;
            String cartNumber = (String) fields[0];
            String product = (String) fields[1];
            Long orderId = (Long) fields[2];
            String email = (String) fields[3];
            String phone = (String) fields[4];
            String address = (String) fields[5];

    %>
    <tr>
        <td>
            <%= cartNumber %>
        </td>
        <td>
            <%= product %>
        </td>
        <td>
            <%= email %>
        </td>
        <td>
            <%= phone %>
        </td>
        <td>
            <%= address %>
        </td>
        <td>
            <form action="/admin/order/complete" method="POST">
                <input type="submit" value="Narudžba Završena">
                <input name="orderId" type="hidden" value="<%=orderId%>">
            </form>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
