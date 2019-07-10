import models.ProductsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProductsSessionBean implements ProductSessionEJBRemote{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-PU");
    private EntityManager em = factory.createEntityManager();

    @Override
    public List<ProductsEntity> findAll() {
        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        List<ProductsEntity> result = em.createNamedQuery("products.findAll").getResultList();
        return result;
    }
}
