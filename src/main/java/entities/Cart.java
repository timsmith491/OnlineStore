package entities;

import javax.persistence.*;

/**
 * Created by Tim on 15/03/2017.
 */


public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @OneToOne
    private Customer customer;

    private int cartId;
    private int itemId;
    private int customerId;

    public Cart(){

    }

    public Cart(int itemId, int customerId) {
        this.itemId = itemId;
        this.customerId = customerId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", itemId=" + itemId +
                ", customerId=" + customerId +
                '}';
    }
}
