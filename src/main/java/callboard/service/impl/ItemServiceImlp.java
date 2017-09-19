package callboard.service.impl;

import callboard.dao.ItemDAO;
import callboard.dao.impl.ItemDAOImlp;
import callboard.instance.Item;
import callboard.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Random;

/**
 * Created by Temp on 19.09.2017.
 */
public class ItemServiceImlp implements ItemService {
    private ItemDAO idao;

    @Autowired
    public void setItemService(ItemDAOImlp idao) {
        this.idao = idao;
    }

    public List<Item> getItems() {
        return idao.getItems();
    }

    public Item getItemById(Integer id) {
        return idao.getItemById(id);
    }

    public void addItem(Item i) {
        idao.addItem(i);
    }

    public Item createItem(String name, int price, String about, String img, String smallimg, String category, String owner) {
        return new Item(new Random().nextInt(), name, price, smallimg, img, about, category, owner);
    }

    public List<Item> getItemsByCategory(String category) {
        return idao.getItemsByCategory(category);
    }

    public List<Item> getItemsByLogin(String login) {
        return idao.getItemsByLogin(login);
    }
}
