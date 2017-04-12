package RestApi;


import dao.ReviewDao;
import entities.Customer;
import entities.Review;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/review")
public class ReviewApi {

    ReviewDao reviewDao = new ReviewDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Review> findAllComments(){

        return reviewDao.findAllReviews();
    }




}
