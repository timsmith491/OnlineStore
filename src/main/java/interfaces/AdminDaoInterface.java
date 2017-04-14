package interfaces;

import entities.Admin;

import java.util.List;

/**
 * Created by Tim on 14/04/2017.
 */
public interface AdminDaoInterface {

    void createAdmin(Admin admin);

    List<Admin> findAllAdmins();

    Admin findByUserName(String username);




}
