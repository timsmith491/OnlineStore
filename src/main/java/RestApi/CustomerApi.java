package RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CustomerDao;
import entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/customer")
public class CustomerApi {

    CustomerDao customerDao = new CustomerDao();

    @GET
    @Path(value = "/hello")
    @Produces(value = "application/json")
    public String hello(){
        return "Hello";
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Customer> findAllCustomers(){

        return customerDao.findAllCustomers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addCustomer")
    public Customer addCustomer(String customerJson) {
        Customer customer = null;
        try {
            customer = mapCustomer(customerJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Should form values be taken as strings for all??
        customerDao.createCustomer(customer);
        return customer;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginCustomer")
    public Customer loginCustomer(String customerJson){
        Customer customer = null;
        try {
            customer = mapCustomer(customerJson);//Same as the addCustomer??

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert customer != null;
        Customer c =customerDao.findByUserName(customer.getUsername());
        if(customer.getPassword().equals(c.getPassword()))
            return customer;
        else
            return null;
    }


    private Customer mapCustomer(String customerJson) throws IOException {
        Customer customer = null;
        customer = new ObjectMapper().readValue(customerJson, Customer.class);

        return customer;

    }

}
