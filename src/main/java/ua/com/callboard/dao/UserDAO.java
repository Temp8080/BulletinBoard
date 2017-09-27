package ua.com.callboard.dao;

import ua.com.callboard.instance.User;

import java.util.List;

/**
 * Created by Temp on 13.09.2017.
 */
public interface UserDAO {
    List<User> getUsers();

    User getUserByLogin(String login);

    void addUser(User user);

    void updateUserFav(User user, String update);

    void deleteUser(User user);
}
