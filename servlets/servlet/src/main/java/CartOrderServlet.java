import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartOrderServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private OrderSessionEJBRemote OrderBean;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        UserSessionFactory userSession = (UserSessionFactory) session.getAttribute("user");
        CartSessionFactory cart = (CartSessionFactory) session.getAttribute("cart");
        if(userSession!=null && userSession.isLoggedIn()){
            OrderBean.addOrder(cart.getCartNumber(), userSession.getUser(), cart.getCartItemsList());
            session.removeAttribute("cart");
            request.setAttribute("order.cartNumber", cart.getCartNumber());
            request.setAttribute("order.phone", userSession.getUser().getPhone());
            request.setAttribute("order.address", userSession.getUser().getShippingAddress());
            request.setAttribute("order.items", cart.getCartItemsList());
            request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
        }else{
            response.sendRedirect("/user/login");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
