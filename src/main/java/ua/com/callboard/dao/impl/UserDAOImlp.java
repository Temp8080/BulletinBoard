
package ua.com.callboard.dao.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.callboard.dao.UserDAO;
import ua.com.callboard.instance.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAOImlp implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;

    public List<User> getUsers() {
        logger.info("Get all users from db");
        return template.loadAll(User.class);
    }

    public User getUserByLogin(String login) {
        logger.info("User with login" + login + " was getted from db");
        return ((User) template.find("from User u where u.login = ?", login).iterator().next());
    }

    public void addUser(User user) {
        template.save(user);
        logger.info("Add new user with login " + user.getLogin());
    }

    public void updateUser(User user) {
        template.update(user);
        logger.info("Update user with login " + user.getLogin());
    }

    public void deleteUser(User user){
        template.delete(user);
        logger.info("Delete user with login " + user.getLogin());
    }
}
