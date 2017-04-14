package interfaces;

import entities.Comment;

import java.util.List;

/**
 * Created by Tim on 14/04/2017.
 */
public interface CommentDaoInterface {

    void createComment(Comment comment);

    List<Comment> findAllComments();
}
