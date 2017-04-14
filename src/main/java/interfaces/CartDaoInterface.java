package interfaces;

import entities.CartItem;

import java.util.List;


public interface CartDaoInterface {

    void createCart(CartItem cartItem);

    void mergeCart(CartItem cartItem);

    List<CartItem> findAllCarts();
}
