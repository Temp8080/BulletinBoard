
package ua.com.callboard.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.callboard.dao.ItemDAO;
import ua.com.callboard.instance.Item;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ItemDAOImlp implements ItemDAO {

    private static final Logger logger = Logger.getLogger(ItemDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;

    public List<Item> getItems() {
        logger.info("get all items from db");
        return template.loadAll(Item.class);
    }

    public Item getItemById(Integer id) {
        logger.info("Get item by id" + id + " was getted from db");
        return template.get(Item.class, id);
    }

    public void addItem(Item item) {
        logger.info("Item saved in db");
        template.save(item);
    }

    public List<Item> getItemsByCategory(String category) {
        CriteriaBuilder criteriaBuilder = entityManager.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("category"), category));

        logger.info("Get Items by Category"+category+" from db");
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Item> getItemsByLogin(String login) {

        CriteriaBuilder criteriaBuilder = entityManager.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("owner"), login));

        logger.info("Get Items by Owner "+login+" from db");
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void updateItem(Item item){
        template.update(item);
        logger.info("Update Item "+item+" in db");
    }

    public void deleteItem(Item item){
        template.delete(item);
        logger.info("Delete Item "+item+" in db");
    }
}
