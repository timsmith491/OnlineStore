package RestApi;

import dao.AdminDao;
import dao.CartDao;
import dao.CustomerDao;
import entities.Cart;
import entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/viewCarts")
public class CartApi {

    CartDao cartDao = new CartDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String findAllCarts(){
        List<Cart> carts = cartDao.findAllCarts();
        for (Cart c: carts){
            c.getCartId();
            c.getCustomerId();
            c.getItemId();

        }
        carts.toString();
        return "All carts" + carts.toString();
    }

    @POST
    @Produces
    @Path("/addCart")
    public void addUserpublic(@FormParam("cartId") int cartId, @FormParam("customerId") int customerId,
                              @FormParam("itemId") int itemId){

        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setCustomerId(customerId);
        cart.setItemId(itemId);
        cartDao.createCart(cart);

    }

}
