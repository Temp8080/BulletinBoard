package callboard.service.impl;

import callboard.dao.UserDAO;
import callboard.instance.User;
import callboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by Temp on 19.09.2017.
 */
public class UserServiceImpl implements UserService {
    private UserDAO udao;

    @Autowired
    public void setUserService(UserDAO udao) {
        this.udao = udao;
    }

    public List<User> getUsers() {
        return udao.getUsers();
    }

    public User getUserByLogin(String login) {
        return udao.getUserByLogin(login);
    }

    public void addUser(User u) {
        udao.addUser(u);
    }

    public void updateUserFav(User u, String update) {
        udao.updateUserFav(u, update);
    }
}
