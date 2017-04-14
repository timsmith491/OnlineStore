package dao;

import entities.Customer;

import javax.persistence.EntityManager;

import interfaces.CustomerDaoInterface;
import persistence.PersistenceUtil;
import java.util.List;

/**
 * Created by Tim on 14/03/2017.
 */
public class CustomerDao implements CustomerDaoInterface{

    public void createCustomer(Customer customer){
        PersistenceUtil.persist(customer);
    }

    public List<Customer> findAllCustomers() {
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> customers = (List<Customer>)
                em.createNamedQuery("Customer.findAll").getResultList();
        em.close();

        return customers;
    }

    public Customer findByUserName(String username) {
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> customers = (List<Customer>)
                em.createNamedQuery("Customer.findByUsername").setParameter("username", username).getResultList();

        em.close();
        if(customers.size() > 0 ){
            return customers.get(0);
        }
        else{
            return null;
        }

    }
}
