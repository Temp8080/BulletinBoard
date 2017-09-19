
package callboard.dao.impl;


import callboard.dao.UserDAO;
import callboard.instance.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import callboard.service.impl.HibernateUtil;


public class UserDAOImlp implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class);

    public List<User> getUsers() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<User> users = s.createCriteria(User.class).list();
        s.close();
        logger.info("Get all users from db");
        return users;
    }

    public User getUserByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM User WHERE login='" + login + "'");
        User u = (User) q.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.info("User with login" + login + " was getted from db");
        return u;
    }

    public void addUser(User u) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        logger.info("Add new user with login " + u.getLogin());
        s.close();
    }

    public void updateUserFav(User u, String update) {
        u.setFav(update);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(u);
        s.getTransaction().commit();
        s.close();
    }
}
