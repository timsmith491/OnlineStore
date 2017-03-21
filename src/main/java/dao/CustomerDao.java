package dao;

import entities.Customer;

import javax.persistence.EntityManager;
import persistence.PersistenceUtil;
import java.util.List;

/**
 * Created by Tim on 14/03/2017.
 */
public class CustomerDao {

    public void createCustomer(Customer customer){
        PersistenceUtil.persist(customer);
    }

    public static List<Customer> findAllCustomers() {
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> customers = (List<Customer>)
                em.createNamedQuery("customer.findAll").getResultList();
        em.close();

        return customers;
    }
}
