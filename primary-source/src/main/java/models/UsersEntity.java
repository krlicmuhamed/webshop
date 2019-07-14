package models;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "webshop")
@NamedQueries({
        @NamedQuery(name="users.findByLogin", query="SELECT u FROM UsersEntity u WHERE u.email = :Email AND u.password = :Password")
})
public class UsersEntity {
    private long id;
    private String email;
    private String password;
    private String shippingAddress;
    private String phone;
    private String role;
    private Integer itemsBought;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "items_bought")
    public Integer getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(Integer itemsBought) {
        this.itemsBought = itemsBought;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (shippingAddress != null ? !shippingAddress.equals(that.shippingAddress) : that.shippingAddress != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (itemsBought != null ? !itemsBought.equals(that.itemsBought) : that.itemsBought != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (itemsBought != null ? itemsBought.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
