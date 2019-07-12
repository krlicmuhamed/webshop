import models.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless(name = "UserSessionEJB")
public class UserSessionBean implements UserSessionEJBRemote {
    public UserSessionBean() {
    }
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-PU");
    private EntityManager em = factory.createEntityManager();

    @Override
    public UsersEntity findByLogin(String Email, String Password) {
        UsersEntity result = (UsersEntity) em.createNamedQuery("users.findByLogin").setParameter("Email", Email).setParameter("Password",Password).getSingleResult();
        return result;
    }

    @Override
    public void addUser(String email, String password, String phone, String address) {
        em.getTransaction().begin();
        UsersEntity user = new UsersEntity();
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setShippingAddress(address);
        user.setItemsBought(0);
        user.setRole("customer");
        em.persist(user);
        em.getTransaction().commit();
    }
}
