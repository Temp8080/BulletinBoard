package ua.com.callboard.service.impl;

import org.springframework.stereotype.Service;
import ua.com.callboard.dao.ItemDAO;
import ua.com.callboard.instance.Item;
import ua.com.callboard.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Random;

/**
 * Created by Temp on 19.09.2017.
 */
@Service("itemServ")
public class ItemServiceImlp implements ItemService {

    private ItemDAO idao;

    @Autowired
    public void setItemService(ItemDAO idao) {
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
        return new Item(name, price, smallimg, img, about, category, owner);
    }

    public List<Item> getItemsByCategory(String category) {
        return idao.getItemsByCategory(category);
    }

    public List<Item> getItemsByLogin(String login) {
        return idao.getItemsByLogin(login);
    }
}
