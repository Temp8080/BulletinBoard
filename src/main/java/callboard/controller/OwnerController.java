
package callboard.controller;


import callboard.user.UserForOwner;
import callboard.item.ItemConverter;
import callboard.item.ItemForOwner;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import callboard.service.UserService;
import callboard.user.UserConverter;

@Controller
public class OwnerController {

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    @RequestMapping("/owner")
    public ModelAndView singleItem(HttpServletRequest req) {
        ModelAndView model = new ModelAndView("singleOwner");
        String owner = req.getParameter("owner");
        UserForOwner userForOwner = userConverter.userForOwner(userService.getUserByLogin(owner));
        List<ItemForOwner> listItemForOwner = new LinkedList<>();
        listItemForOwner = itemConverter.listItemForOwner(owner);
        model.addObject("user", userForOwner);
        model.addObject("items", listItemForOwner);
        return model;
    }
}
