package ua.com.callboard.dao;

import ua.com.callboard.instance.Item;

import java.util.List;

/**
 * Created by Temp on 13.09.2017.
 */
public interface ItemDAO {

    List<Item> getItems();

    Item getItemById(Integer id);

    void addItem(Item item);

    List<Item> getItemsByCategory(String category);

    List<Item> getItemsByLogin(String login);

    void updateItem(Item item);

    void deleteItem(Item item);
}
