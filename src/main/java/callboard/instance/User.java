package callboard.instance;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mvcusers")
public class User implements Serializable {

    @Id
    private int id;
    private String login;
    private String pass;
    private String fav;
    private String phone;

    public User() {
    }

    public User(int id, String login, String pass, String fav, String phone) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.fav = fav;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
