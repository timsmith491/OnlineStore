package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "admin.findAll", query = "select o from Admin o"),
        @NamedQuery(name = "admin.findByUsername", query = "select o from Admin o where o.usernameAdmin=:usernameAdmin"),
})

@XmlRootElement
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

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int adminId) {
        this.id = adminId;
    }

    @XmlElement
    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    @XmlElement
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
