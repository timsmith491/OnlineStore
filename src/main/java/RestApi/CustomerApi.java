package RestApi;

import dao.CustomerDao;
import entities.Customer;

import javax.ws.rs.*;
import java.util.List;

@Path("/customer")
public class CustomerApi {


    @GET
    @Path(value = "/hello")
    @Produces(value = "application/json")
    public String hello(){
        return "Hello";
    }

    CustomerDao customerDao = new CustomerDao();

    @GET
    @Path("/all")
    public String findAllCustomers(){
        List<Customer> customers = customerDao.findAllCustomers();
        for (Customer c: customers){
            c.getCustomerId();
            c.getUsername();
            c.getPassword();
            c.getShippingAddress();
            c.getPaymentMethod();
        }
        customers.toString();
        return "All customers" + customers.toString();
    }

    @POST
    @Produces
    @Path("/register")
    public void addUserpublic(@FormParam("username") String username, @FormParam("password") String password,
                              @FormParam("shippingAddress") String shippingAddress, @FormParam("paymentMethod") String paymentMethod){


//    public void post(String data) {
        Customer customer = new Customer();
//        user.setUsername("tim");
//        user.setPassword("password");

        customer.setUsername(username);
        customer.setPassword(password);
        customer.setShippingAddress(shippingAddress);
        customer.setPaymentMethod(paymentMethod);
        customerDao.createCustomer(customer);
//        System.out.println(data);
//        return user;
    }

}
