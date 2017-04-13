package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "comment.findAll", query = "select o from Comment o")
})

@XmlRootElement
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String comment;
    private int rating;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Item item;


    public Comment(){

    }

    public Comment(String comment, int rating, Customer customer, Item item) {
        this.comment = comment;
        this.rating = rating;
        this.customer = customer;
        this.item = item;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlElement
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @XmlElement
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlElement
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment=" + comment +
                ", rating=" + rating +
                ", customer=" + customer +
                ", item=" + item +
                '}';
    }
}
