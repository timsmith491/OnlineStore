package dao;

import entities.Comment;
import entities.Customer;
import interfaces.CommentDaoInterface;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Tim on 19/03/2017.
 */
public class CommentDao implements CommentDaoInterface{
    public void createComment(Comment comment){
        PersistenceUtil.persist(comment);
    }

    public List<Comment> findAllComments() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Comment> comments = (List<Comment>)
                em.createNamedQuery("comment.findAll").getResultList();
        em.close();

        return comments;
    }
}
