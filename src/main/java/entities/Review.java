package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "review.findAll", query = "select o from Review o")
})

@XmlRootElement
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Long comment;
    private int commentRating;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Item item;

    public Review() {

    }

    public Review(Long comment, int commentRating, Customer customer, Item item) {
        this.comment = comment;
        this.commentRating = commentRating;
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
    public Long getComment() {
        return comment;
    }

    public void setComment(Long comment) {
        this.comment = comment;
    }

    @XmlElement
    public int getCommentRating() {
        return commentRating;
    }

    public void setCommentRating(int commentRating) {
        this.commentRating = commentRating;
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
        return "Review{" +
                "id=" + id +
                ", comment=" + comment +
                ", commentRating=" + commentRating +
                ", customer=" + customer +
                ", item=" + item +
                '}';
    }
}