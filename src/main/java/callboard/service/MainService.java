package callboard.service;

import callboard.instance.Item;
import callboard.user.UserForSession;

import java.util.List;

/**
 * Created by Temp on 17.09.2017.
 */
public interface MainService {

    boolean isLogin(UserForSession u);

    List<Item> filterMain(String login, String category);

}
