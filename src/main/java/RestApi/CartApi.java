package RestApi;

import com.fasterxml.jackson.core.type.TypeReference;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/purchaseAllCartItem")
    public void completePurchase(String cartItemPurchaseJson ){
        List<CartItem> cartItems = null;

        try {
            cartItems = mapCartItemsList(cartItemPurchaseJson);//
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(CartItem cartItem : cartItems){
            cartItem.setPaid(true);
            cartDao.mergeCart(cartItem);//cha
        }


    }

    private CartItem mapCartItePurchase(String cartItemPurchaseJson) throws IOException {
        CartItem cartItem = null;
        cartItem = new ObjectMapper().readValue(cartItemPurchaseJson, CartItem.class);

        return cartItem;
    }

    private List<CartItem> mapCartItemsList(String jsonCartItems) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<CartItem> cartItems = mapper.readValue(jsonCartItems, new TypeReference<List<CartItem>>(){});

        return cartItems;
    }


    private CartItem mapCartItem(String cartItemJson) throws IOException {
        CartItem cartItem = null;
        cartItem = new ObjectMapper().readValue(cartItemJson, CartItem.class);

        return cartItem;

    }

}
