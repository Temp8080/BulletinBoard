
package callboard.user;


public class UserForSession {
    private int id;
    private String login;
    private String pass;
    private String fav;
    private String phone;

    public UserForSession() {
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

    public UserForSession withId(int id) {
        this.id = id;
        return this;
    }

    public UserForSession withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserForSession withPass(String pass) {
        this.pass = pass;
        return this;
    }

    public UserForSession withFav(String fav) {
        this.fav = fav;
        return this;
    }

    public UserForSession withPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
