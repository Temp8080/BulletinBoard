package callboard.service;

import callboard.data.Favorites;
import callboard.instance.Item;
import callboard.item.ItemForOwner;
import callboard.user.UserForSession;

import java.util.List;

/**
 * Created by Temp on 11.09.2017.
 */
public interface FavoriteService {

    Favorites updateFav(Favorites fav, String sId);

    List<ItemForOwner> crudFavorites(UserForSession userForSession, String id, List<Item> listItems);

    Integer stringToInteger(String sInt);
}
