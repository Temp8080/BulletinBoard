package ua.com.callboard.service.impl;

import org.springframework.stereotype.Service;
import ua.com.callboard.dao.UserDAO;
import ua.com.callboard.instance.User;
import ua.com.callboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by Temp on 19.09.2017.
 */
@Service("userServ")
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

    public void updateUser(User user) {
        udao.updateUser(user);
    }
}
