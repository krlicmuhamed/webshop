import models.ProductsEntity;

import java.util.ArrayList;
import java.util.List;

public class CartSessionFactory {
    private String cartNumber;
    private List<ProductsEntity> cartItemsList;

    public CartSessionFactory(){
        this.cartItemsList = new ArrayList<>();
        this.setCartNumber();
    }
    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public void setCartNumber() {
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        int count = 7;
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        this.cartNumber = builder.toString();
    }

    public void addCartProductItem(ProductsEntity product){
        cartItemsList.add(product);
    }

    public void addCartProductItem(ProductsEntity product, int Quantity){
        for(int i = 0; i < Quantity; i++){
            cartItemsList.add(product);
        }
    }

    public List<ProductsEntity> getCartItemsList() {
        return this.cartItemsList;
    }
}
