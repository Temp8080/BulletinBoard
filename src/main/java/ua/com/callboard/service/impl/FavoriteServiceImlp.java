package ua.com.callboard.service.impl;

import ua.com.callboard.data.Favorites;
import ua.com.callboard.instance.Item;
import ua.com.callboard.item.ItemConverter;
import ua.com.callboard.item.ItemForOwner;
import ua.com.callboard.service.FavoriteService;
import ua.com.callboard.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.com.callboard.user.UserConverter;
import ua.com.callboard.user.UserForSession;

import java.util.LinkedList;
import java.util.List;

public class FavoriteServiceImlp implements FavoriteService {

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    public Favorites updateFav(Favorites favorites, String sId) {
        Favorites updateFav = favorites;
        Integer id = stringToInteger(sId);
        if (id != null) {
            if (!updateFav.getFav().contains(id)) {
                if (id == 0) {
                    updateFav.getFav().clear();
                }
                if (id > 0) {
                    updateFav.getFav().add(id);
                }
                if (id < 0) {
                    if (updateFav.getFav().size() == 1) {
                        updateFav.getFav().clear();
                    } else {
                        updateFav.removeFav(-id);
                    }
                }
            }
        }
        return updateFav;
    }

    public List<ItemForOwner> crudFavorites(UserForSession userForSession, String id, List<Item> listItems) {
        Favorites fav = new Gson().fromJson(userForSession.getFav(), Favorites.class);
        Favorites upFav = updateFav(fav, id);
        String backToJsonFav = new Gson().toJson(upFav);
        userForSession.setFav(backToJsonFav);
        userService.updateUser(userConverter.sessionForUser(userForSession));
        List<ItemForOwner> listUpdate = new LinkedList<>();
        listUpdate = itemConverter.listItemForAccount(upFav.getFav(), listItems);
        return listUpdate;
    }

    public Integer stringToInteger(String sInt) {
        Integer integer = null;
        if (sInt != null && !sInt.equals("")) {
            integer = Integer.parseInt(sInt);
            return integer;
        }
        return null;
    }
}
