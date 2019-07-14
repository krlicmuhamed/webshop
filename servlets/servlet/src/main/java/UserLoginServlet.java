import models.UsersEntity;
import util.hashPassword;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends javax.servlet.http.HttpServlet {

    @EJB
    private UserSessionEJBRemote UserBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserSessionFactory userSession = (UserSessionFactory) session.getAttribute("user");
        if(userSession!=null && userSession.getUser()!=null){
            response.sendRedirect("/cart");
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UsersEntity user = UserBean.findByLogin(email, hashPassword.string(password));
        if(user!=null){
            userSession = new UserSessionFactory();
            userSession.setUser(user);
            userSession.setIsLoggedIn(true);
            session.setAttribute("user", userSession);
            session.setAttribute("user.email", userSession.getUser().getEmail());
            session.setAttribute("user.loggedIn", userSession.isLoggedIn());
            response.sendRedirect("/cart");
        }else{
            request.setAttribute("message", "User email or password is not correct.");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserSessionFactory userSession = (UserSessionFactory) session.getAttribute("user");
        if(userSession!=null){
            response.sendRedirect("/cart");
        }else{
            request.setAttribute("message", "Please enter your credentials.");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
