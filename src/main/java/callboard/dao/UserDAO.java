package callboard.dao;

import callboard.instance.User;

import java.util.List;

/**
 * Created by Temp on 13.09.2017.
 */
public interface UserDAO {
    List<User> getUsers();

    User getUserByLogin(String login);

    void addUser(User u);

    void updateUserFav(User u, String update);
}
