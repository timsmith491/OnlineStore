package RestApi;


import dao.CommentDao;
import entities.Comment;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/comment")
public class CommentApi {

    CommentDao commentDao = new CommentDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Comment> findAllComments(){

        return commentDao.findAllComments();
    }

    @POST
    @Produces
    @Path("/post")
    public void addCommentpublic(@FormParam("customerName") String customerName, @FormParam("password") String password,
                              @FormParam("shippingAddress") String shippingAddress, @FormParam("paymentMethod") String paymentMethod) {

        Comment comment = new Comment();
        comment.setCustomerName(customerName);

    }
}
