package interfaces;

import entities.Customer;

import java.util.List;

/**
 * Created by Tim on 14/04/2017.
 */
public interface CustomerDaoInterface {

    void createCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findByUserName(String username);
}
