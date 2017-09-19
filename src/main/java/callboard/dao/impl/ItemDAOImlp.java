
package callboard.dao.impl;

import callboard.dao.ItemDAO;
import callboard.instance.Item;
import callboard.service.impl.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class ItemDAOImlp implements ItemDAO {

    private static final Logger logger = Logger.getLogger(ItemDAO.class);

    public List<Item> getItems() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> items = s.createCriteria(Item.class).list();
        s.close();
        logger.info("get all items from db");
        return items;
    }

    public Item getItemById(Integer id) {
        Item item = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM Item WHERE id='" + id + "'");
        item = (Item) q.uniqueResult();
        s.getTransaction().commit();
        s.close();
        logger.info("Get item by id" + id + " was getted from db");
        return item;
    }

    public void addItem(Item i) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
        logger.info("Item saved in db");
    }

    public List<Item> getItemsByCategory(String category) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> items = null;
        s.beginTransaction();
        Query q = s.createQuery("FROM Item WHERE category='" + category + "'");
        items = q.list();
        s.getTransaction().commit();
        s.close();
        return items;
    }

    public List<Item> getItemsByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Item> items = null;
        s.beginTransaction();
        Query q = s.createQuery("FROM Item WHERE owner='" + login + "'");
        items = q.list();
        s.getTransaction().commit();
        s.close();
        return items;
    }
}
