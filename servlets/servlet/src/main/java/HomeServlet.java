import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        CartSessionFactory cart = (CartSessionFactory) session.getAttribute("cart");
        if(cart==null){
            CartSessionFactory Cart = new CartSessionFactory();
            session.setAttribute("cart", Cart);
        }
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
