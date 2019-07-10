package models;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "webshop", catalog = "")
public class OrdersEntity {
    private long id;
    private String cartNumber;
    private int productId;
    private int userId;
    private byte pending;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cartNumber")
    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    @Basic
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "pending")
    public byte getPending() {
        return pending;
    }

    public void setPending(byte pending) {
        this.pending = pending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (userId != that.userId) return false;
        if (pending != that.pending) return false;
        if (cartNumber != null ? !cartNumber.equals(that.cartNumber) : that.cartNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cartNumber != null ? cartNumber.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + userId;
        result = 31 * result + (int) pending;
        return result;
    }
}
