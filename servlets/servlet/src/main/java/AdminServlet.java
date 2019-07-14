import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private OrderSessionEJBRemote OrderBean;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        UserSessionFactory userSession = (UserSessionFactory) session.getAttribute("user");
        if(userSession!=null && userSession.getUser()!=null && userSession.isLoggedIn() && userSession.getUser().getRole().equals("admin")){
            ArrayList ordersList = OrderBean.getPendingCartOrders();
            request.setAttribute("orders", ordersList);
            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        }else{
            request.setAttribute("message", "You need to login as Admin to continue.");
            session.removeAttribute("user");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
