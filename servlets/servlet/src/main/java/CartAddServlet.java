import models.ProductsEntity;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartAddServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private ProductSessionEJBRemote ProductsBean;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        CartSessionFactory CartSession = (CartSessionFactory) session.getAttribute("cart");

        Long ProductId = Long.parseLong(request.getParameter("productId"));
        Integer ProductQuantity = Integer.parseInt(request.getParameter("quantity"));

        System.out.println(request.getAttributeNames());

        ProductsEntity Product = ProductsBean.findById(ProductId);
        CartSession.addCartProductItem(Product, ProductQuantity);
        response.sendRedirect("/cart");
    }
}
