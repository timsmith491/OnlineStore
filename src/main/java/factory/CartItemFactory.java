package factory;

import dao.CartDao;
import entities.CartItem;
import interfaces.CartDaoInterface;

public class CartItemFactory {

    public CartDaoInterface getCartDao(String cartType){

        if(cartType == null) {
            return null;
        }
        if(cartType.equalsIgnoreCase("CartItem")) {
            return new CartDao();
        }

        return null;
    }
}
