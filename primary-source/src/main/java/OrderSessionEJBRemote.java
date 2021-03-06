import models.OrdersEntity;
import models.ProductsEntity;
import models.UsersEntity;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface OrderSessionEJBRemote {
    void addOrder(String cartNumber, UsersEntity user, List<ProductsEntity> cart);
    ArrayList getPendingCartOrders();
    void setOrderComplete(List<OrdersEntity> orders);
}
