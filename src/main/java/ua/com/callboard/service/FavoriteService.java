package ua.com.callboard.service;

import ua.com.callboard.data.Favorites;
import ua.com.callboard.instance.Item;
import ua.com.callboard.item.ItemForOwner;
import ua.com.callboard.user.UserForSession;

import java.util.List;

/**
 * Created by Temp on 11.09.2017.
 */
public interface FavoriteService {

    Favorites updateFav(Favorites fav, String sId);

    List<ItemForOwner> crudFavorites(UserForSession userForSession, String id, List<Item> listItems);

    Integer stringToInteger(String sInt);
}
