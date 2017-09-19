package callboard.dao;

import callboard.instance.Item;

import java.util.List;

/**
 * Created by Temp on 13.09.2017.
 */
public interface ItemDAO {
    List<Item> getItems();

    Item getItemById(Integer id);

    void addItem(Item i);

    List<Item> getItemsByCategory(String category);

    List<Item> getItemsByLogin(String login);
}
