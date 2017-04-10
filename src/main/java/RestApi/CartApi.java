package RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CartDao;
import entities.CartItem;
import entities.Customer;
import entities.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/cart")
public class CartApi {

    CartDao cartDao = new CartDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<CartItem> findAllCarts(){
        return cartDao.findAllCarts();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addCartItem")
    public CartItem addCartItem(String cartItemJson ){
        CartItem cartItem = null;
        try {
            cartItem = mapCartItem(cartItemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        cartDao.createCart(cartItem);
        return cartItem;

    }

    private CartItem mapCartItem(String cartItemJson) throws IOException {
        CartItem cartItem = null;
        cartItem = new ObjectMapper().readValue(cartItemJson, CartItem.class);

        return cartItem;

    }

}
