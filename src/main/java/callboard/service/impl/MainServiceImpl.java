package callboard.service.impl;

import callboard.instance.Item;
import callboard.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import callboard.user.UserForSession;
import callboard.service.ItemService;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Temp on 17.09.2017.
 */

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Autowired
    @Qualifier(value = "itemServ")
    private ItemService itemService;

    public boolean isLogin(UserForSession userForSession) {
        return userForSession != null;
    }

    public List<Item> filterMain(String login, String category) {
        List<Item> listItems = null;
        List<Item> listItemSort = new LinkedList<>();
        if (category != null
                && login != null) {
            if (login.length() > 0) {
                listItems = itemService.getItems();
                for (Item i : listItems) {
                    if (i.getOwner().equals(login)) {
                        listItemSort.add(i);
                    }
                }
                if (!category.equals("all")) {
                    listItems = listItemSort;
                    listItemSort = new LinkedList<>();
                    for (Item i : listItems) {
                        if (category.equals(i.getCategory())) {
                            listItemSort.add(i);
                        }
                    }
                }
            } else {
                if (!category.equals("all")) {
                    listItems = itemService.getItems();
                    listItemSort = new LinkedList<>();
                    for (Item i : listItems) {
                        if (category.equals(i.getCategory())) {
                            listItemSort.add(i);
                        }
                    }
                } else {
                    listItemSort = itemService.getItems();
                }
            }
        } else {
            listItemSort = itemService.getItems();
        }
        return listItemSort;
    }
}
