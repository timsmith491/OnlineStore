package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tim on 15/03/2017.
 */
@NamedQueries({
        @NamedQuery(name = "cartItem.findAll", query = "select o from CartItem o")
})

@XmlRootElement
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean paid;
    private int quantity;

    @ManyToOne
    private Customer customer;

//    @ManyToMany
//    private Item item;///////////////////////////////////////////////////Update



    public CartItem() {

    }

    public CartItem(boolean paid, int quantity, Customer customer, Item item) {
        this.paid = paid;
        this.quantity = quantity;
        this.customer = customer;
       // this.item = item;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @XmlElement
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", paid=" + paid +
                ", quantity=" + quantity +
                '}';
    }
}