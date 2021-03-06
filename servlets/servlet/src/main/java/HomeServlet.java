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
        UserSessionFactory user = (UserSessionFactory) session.getAttribute("user");
        if(user==null || user.getUser()==null){
            session.setAttribute("user.loggedIn", false);
        }else{
            session.setAttribute("user.email", user.getUser().getEmail());
            session.setAttribute("user.loggedIn", user.isLoggedIn());
            boolean isAdmin = (true ? user.getUser().getRole()=="admin" : false);
            session.setAttribute("user.isAdmin", isAdmin);
        }
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
