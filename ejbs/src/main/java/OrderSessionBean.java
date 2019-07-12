import models.OrdersEntity;
import models.ProductsEntity;
import models.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless(name = "OrderSessionEJB")
public class OrderSessionBean implements OrderSessionEJBRemote{
    public OrderSessionBean() {
    }
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-PU");
    private EntityManager em = factory.createEntityManager();


    @Override
    public void addOrder(String cartNumber, UsersEntity user, List<ProductsEntity> cart) {
        em.getTransaction().begin();
        for(ProductsEntity cartProduct : cart){
            OrdersEntity order = new OrdersEntity();
            order.setCartNumber(cartNumber);
            order.setUserId((int) user.getId());
            order.setProductId((int) cartProduct.getId());
            order.setPending(true);
            em.persist(order);
        }
        em.getTransaction().commit();
    }
}
