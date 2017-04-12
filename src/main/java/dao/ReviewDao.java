package dao;

import entities.Review;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Tim on 19/03/2017.
 */
public class ReviewDao {
    public void createReview(Review review){
        PersistenceUtil.persist(review);
    }

    public static List<Review> findAllReviews() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Review> reviews = (List<Review>)
                em.createNamedQuery("review.findAll").getResultList();
        em.close();

        return reviews;
    }
}
