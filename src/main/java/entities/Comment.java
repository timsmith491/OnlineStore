package entities;

import javax.persistence.*;

/**
 * Created by Tim on 15/03/2017.
 */
@NamedQueries({
        @NamedQuery(name = "comment.findAll", query = "select o from Comment o")
})

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    private String customerName;
    private String shippingAddress;
    private String paymentMethod;

    public Comment(){

    }

    public Comment(String customerName, String shippingAddress, String paymentMethod) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", customerName='" + customerName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
