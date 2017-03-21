package RestApi;


import dao.AdminDao;
import dao.CustomerDao;
import entities.Admin;
import entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/admin")
public class AdminApi {

//    CustomerDao customerDao = new CustomerDao();
    private AdminDao adminDao = new AdminDao();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Admin> findAllAdmins(){
       return adminDao.findAllAdmins();
    }

    @POST
    @Produces
    @Path("/register")
    public void addUserpublic(@FormParam("username") String username, @FormParam("password") String password) {

        Admin admin = new Admin();

        admin.setUsernameAdmin(username);
        admin.setPasswordAdmin(password);
        adminDao.createAdmin(admin);
//        System.out.println(data);
//        return user;
    }
}
