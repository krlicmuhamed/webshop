import models.ProductsEntity;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        CartSessionFactory cart = (CartSessionFactory) session.getAttribute("cart");
        if(cart==null){
            cart = new CartSessionFactory();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("cart.items", cart.getCartItemsList());

        Double ProductTotal = 0.0;
        for (ProductsEntity productsEntity : cart.getCartItemsList())
            ProductTotal += productsEntity.getPrice();
        request.setAttribute("cart.total", ProductTotal);

        request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }
}
