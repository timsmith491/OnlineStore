package RestApi;

import dao.AdminDao;
import dao.CartDao;
import dao.CustomerDao;
import entities.Cart;
import entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cart")
public class CartApi {

    CartDao cartDao = new CartDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public
        List<Cart> findAllCart(){
        cartDao.findAllCarts();

        return cartDao.findAllCarts();
    }

    @POST
    @Produces
    @Path("/addCart")
    public void addUserpublic(@FormParam("cartId") int cartId, @FormParam("customerId") int customerId,
                              @FormParam("itemId") int itemId){

//        Cart cart = new Cart();
//        cart.setId(cartId);
//        cart.setId(customerId);
//        cart.setId(itemId);
//        cartDao.createCart(cart);

    }

}
