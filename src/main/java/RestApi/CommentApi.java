package RestApi;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CommentDao;
import entities.Comment;
import entities.Item;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addComment")
    public Comment addComment(String commentJson){
        Comment comment = null;

        try {
            comment = mapComment(commentJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        commentDao.createComment(comment);
        return comment;
    }




    private Comment mapComment(String commentJson) throws IOException {
        Comment comment = null;
        comment = new ObjectMapper().readValue(commentJson, Comment.class);

        return comment;

    }
}
