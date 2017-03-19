package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tim on 19/03/2017.
 */

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private int adminId;
    private String usernameAdmin;
    private String passwordAdmin;

    public Admin(){

    }

    public Admin(String usernameAdmin, String passwordAdmin) {
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", usernameAdmin='" + usernameAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}
