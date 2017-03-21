package entities;

import javax.persistence.*;

/**
 * Created by Tim on 15/03/2017.
 */
@NamedQueries({
        @NamedQuery(name = "cart.findAll", query = "select o from Cart o")
})


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public Cart() {

    }


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