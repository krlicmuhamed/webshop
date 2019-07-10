import models.ProductsEntity;

import java.util.List;

public interface ProductSessionEJBRemote {
    List<ProductsEntity> findAll();
}
