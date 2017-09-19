
package callboard.controller;

import callboard.instance.Item;
import callboard.item.ItemConverter;
import callboard.user.UserConverter;
import callboard.user.UserForOwner;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import callboard.service.MainService;
import callboard.service.UserService;
import callboard.user.UserForSession;

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
