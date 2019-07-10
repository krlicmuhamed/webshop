import models.ProductsEntity;

import javax.ejb.EJB;
import java.io.IOException;
import java.util.List;

public class CartServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        ServletContext servletContext = getServletConfig().getServletContext();
//        List<ProductsEntity> productsList = ProductsBean.findAll();
//        request.setAttribute("products", productsList);
        request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }
}
