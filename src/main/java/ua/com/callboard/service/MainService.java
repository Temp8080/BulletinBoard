package ua.com.callboard.service;

import ua.com.callboard.instance.Item;
import ua.com.callboard.user.UserForSession;

import java.util.List;

/**
 * Created by Temp on 17.09.2017.
 */
public interface MainService {

    boolean isLogin(UserForSession u);

    List<Item> filterMain(String login, String category);

}
