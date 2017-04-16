package factory;


import dao.CartDao;
import entities.CartItem;
import interfaces.CartDaoInterface;

public class CartFactoryRun {

    CartItemFactory cartItemFactory = new CartItemFactory();

    CartDaoInterface cart = cartItemFactory.getCartDao("CartItem");

   //need to create cart.

}
