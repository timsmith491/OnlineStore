package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "admin.findAll", query = "select o from Admin o")
})

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String usernameAdmin;
    private String passwordAdmin;

    public Admin(){

    }

    public Admin(String usernameAdmin, String passwordAdmin) {
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int adminId) {
        this.id = adminId;
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
                "adminId=" + id +
                ", usernameAdmin='" + usernameAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}
