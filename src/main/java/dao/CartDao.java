package dao;


import entities.CartItem;

import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CartDao {
    public void createCart(CartItem cart){
        PersistenceUtil.persist(cart);
    }

    public static List<CartItem> findAllCarts() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<CartItem> carts = (List<CartItem>)
                em.createNamedQuery("cartItem.findAll").getResultList();
        em.close();

        return carts;
    }


}
