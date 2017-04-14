package RestApi;


import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AdminDao;
import dao.CustomerDao;
import entities.Admin;
import entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/admin")
public class AdminApi {


//    CustomerDao customerDao = new CustomerDao();
     AdminDao adminDao = new AdminDao();
//    private AdminApi(){}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Admin> findAllAdmins(){
       return adminDao.findAllAdmins();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addAdmin")
    public Admin addAdmin(String adminJson) {

        Admin admin = Admin.getInstance();

        try {
            admin = mapAdmin(adminJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Should form values be taken as strings for all??
        adminDao.createAdmin(admin);
        return admin;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/loginAdmin")
    public Admin loginAdmin(String adminJson){
        Admin admin = null;
        try {
            admin = mapAdmin(adminJson);//Same as the addCustomer??

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert admin != null;
        Admin a =adminDao.findByUserName(admin.getUsernameAdmin());
        if(admin.getPasswordAdmin().equals(a.getPasswordAdmin()))
            return admin;
        else
            return null;
    }


    private Admin mapAdmin(String adminJson) throws IOException {
        Admin admin = null;
        admin = new ObjectMapper().readValue(adminJson, Admin.class);

        return admin;

    }
}
