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
        request.setAttribute("cartItems", cart.getCartItemsList());
        request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }
}
