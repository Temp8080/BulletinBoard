package ua.com.callboard.service;


import ua.com.callboard.instance.User;

import java.util.List;

/**
 * Created by Temp on 19.09.2017.
 */
public interface UserService {

    List<User> getUsers();

    User getUserByLogin(String login);

    void addUser(User u);

    void updateUserFav(User u, String update);
}
