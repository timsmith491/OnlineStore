package dao;


import entities.Cart;

import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CartDao {
    public void createCart(Cart cart){
        PersistenceUtil.persist(cart);
    }

    public static List<Cart> findAllCarts() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Cart> carts = (List<Cart>)
                em.createNamedQuery("cart.findAll").getResultList();
        em.close();

        return carts;
    }
}
