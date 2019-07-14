import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartRemoveServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        CartSessionFactory CartSession = (CartSessionFactory) session.getAttribute("cart");
        Integer ItemId = Integer.parseInt(request.getParameter("itemId"));
        CartSession.removeCartProductItem(ItemId);
        response.sendRedirect("/cart");
    }

}
