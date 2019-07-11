import models.ProductsEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductSessionEJBRemote {
    List<ProductsEntity> findAll();
    ProductsEntity findById(Long Id);
}
