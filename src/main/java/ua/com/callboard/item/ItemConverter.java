
package ua.com.callboard.item;

import java.util.LinkedList;
import java.util.List;

import ua.com.callboard.instance.Item;
import ua.com.callboard.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class ItemConverter {

    @Autowired
    @Qualifier(value = "itemServ")
    private ItemService itemService;

    public Item getItemById(String id, List<Item> items) {
        int idd = Integer.parseInt(id);
        for (Item item : items) {
            if (item.getId() == idd) {
                return item;
            }
        }
        return null;
    }

    public ItemForSingle convertItemForSingle(Item i) {
        ItemForSingle itemForSingle = new ItemForSingle();
        itemForSingle.withId(i.getId()).withName(i.getName()).withAbout(i.getAbout()).withImg(i.getImg()).withPrice(i.getPrice()).withCategory(i.getCategory()).withOwner(i.getOwner());
        return itemForSingle;
    }

    private ItemForOwner converItemForOwner(Item i) {
        ItemForOwner itemForOwner = new ItemForOwner();
        itemForOwner.withId(i.getId())
                .withSmallImg(i.getSmallimg())
                .withName(i.getName())
                .withOwner(i.getOwner())
                .withAbout(i.getAbout())
                .withCategory(i.getCategory())
                .withPrice(i.getPrice());
        return itemForOwner;
    }

    public List<ItemForOwner> listItemForOwner(String owner) {
        List<ItemForOwner> listItemForOwner = new LinkedList<>();
        List<Item> listItem = itemService.getItemsByLogin(owner);
        for (Item i : listItem) {
            ItemForOwner ifo = converItemForOwner(i);
            listItemForOwner.add(ifo);
        }
        return listItemForOwner;
    }

    public List<ItemForOwner> listItemForAccount(List<Integer> ids, List<Item> items) {
        List<ItemForOwner> listItemForOwner = new LinkedList<>();
        ItemForOwner itemForOwner = new ItemForOwner();
        for (Integer id : ids) {
            for (Item i : items) {
                if (i.getId() == id) {
                    itemForOwner = converItemForOwner(i);
                    listItemForOwner.add(itemForOwner);
                }
            }
        }
        return listItemForOwner;
    }
}
