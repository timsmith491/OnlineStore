package dao;

import entities.Admin;
import entities.Customer;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Tim on 19/03/2017.
 */
public class AdminDao {
    public void createAdmin(Admin admin){
        PersistenceUtil.persist(admin);
    }

    public static List<Admin> findAllAdmins() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Admin> admins = (List<Admin>)
                em.createNamedQuery("admin.findAll").getResultList();
        em.close();

        return admins;
    }

    public Admin findByUserName(String username) {
        EntityManager em = PersistenceUtil.createEM();
        List<Admin> admins = (List<Admin>)
                em.createNamedQuery("admin.findByUsername").setParameter("usernameAdmin", username).getResultList();

        em.close();
        if(admins.size() > 0 ){
            return admins.get(0);
        }
        else{
            return null;
        }

    }
}
