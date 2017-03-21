package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tim on 15/03/2017.
 */
@NamedQueries({
        @NamedQuery(name = "cart.findAll", query = "select o from Cart o")
})

@XmlRootElement
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public Cart() {

    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                '}';
    }
}