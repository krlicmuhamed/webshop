import models.ProductsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless(name = "ProductsSessionEJB")
public class ProductsSessionBean implements ProductSessionEJBRemote{
    public ProductsSessionBean() {
    }
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-PU");
    private EntityManager em = factory.createEntityManager();

    @Override
    public List<ProductsEntity> findAll() {
        List<ProductsEntity> result = em.createNamedQuery("products.findAll").getResultList();
        return result;
    }

    @Override
    public ProductsEntity findById(Long Id) {
        ProductsEntity result = (ProductsEntity) em.createNamedQuery("products.findById").setParameter("Id", Id).getSingleResult();
        return result;
    }
}
