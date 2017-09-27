
package ua.com.callboard.controller;

import ua.com.callboard.instance.Item;
import ua.com.callboard.item.ItemConverter;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.callboard.service.MainService;
import ua.com.callboard.service.UserService;
import ua.com.callboard.user.UserConverter;
import ua.com.callboard.user.UserForOwner;
import ua.com.callboard.user.UserForSession;

@Controller
public class SingleItemController {

    @Autowired
    private MainService mainService;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @RequestMapping("/item")
    public ModelAndView singleItem(HttpServletRequest req) {

        /**
         *  Page for a detailed product description.
         *  Get a list of items from a session, select by id and return to page.
         *  Get owner by login and return to page.
         *  Test if user Log In, for make available button 'Add to favorites'
         */
        ModelAndView model = new ModelAndView("singleItem");
        List<Item> items = (List<Item>) req.getSession().getAttribute("items");
        String id = req.getParameter("id");
        String owner = req.getParameter("owner");
        UserForOwner userForOwner = userConverter.userForOwner(userService.getUserByLogin(owner));
        model.addObject("isLogin", mainService.isLogin((UserForSession) req.getSession().getAttribute("user")));
        model.addObject("items", itemConverter.convertItemForSingle(itemConverter.getItemById(id, items)));
        model.addObject("owner", userForOwner);
        return model;
    }
}
