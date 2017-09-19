
package callboard.user;

public class UserForOwner {
    private String login;
    private String phone;

    public UserForOwner() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserForOwner withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserForOwner withPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
