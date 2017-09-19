package callboard.service;

import callboard.instance.Item;

import java.util.List;

/**
 * Created by Temp on 19.09.2017.
 */
public interface ItemService {

    List<Item> getItems();

    Item getItemById(Integer id);

    void addItem(Item i);

    public Item createItem(String name, int price, String about, String img, String smallimg, String category, String owner);

    List<Item> getItemsByCategory(String category);

    List<Item> getItemsByLogin(String login);
}
