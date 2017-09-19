
package callboard.controller;

import callboard.instance.Item;
import callboard.item.ItemForOwner;
import callboard.service.FavoriteService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import callboard.user.UserForSession;

@Controller
public class UserAccountController {

    @Autowired
    @Qualifier(value = "favServ")
    private FavoriteService favoriteService;

    private UserForSession userForSession = null;
    private List<ItemForOwner> listUpdate = null;
    private List<Item> listItems = null;

    @RequestMapping(value = "/userAccount", method = RequestMethod.GET)
    public ModelAndView userAccount(HttpServletRequest req) {
        ModelAndView model = new ModelAndView("userAccount");
        userForSession = (UserForSession) req.getSession().getAttribute("user");
        listItems = (List<Item>) req.getSession().getAttribute("items");
        listUpdate = favoriteService.crudFavorites(userForSession, req.getParameter("id"), listItems);
        model.addObject("user", userForSession);
        if (listUpdate != null) {
            model.addObject("items", listUpdate);
        }
        return model;
    }

    @RequestMapping(value = "/userAccount", method = RequestMethod.POST)
    public ModelAndView delFromFavorits(@RequestParam String id) {
        ModelAndView model = new ModelAndView("userAccount");
        listUpdate = favoriteService.crudFavorites(userForSession, id, listItems);
        model.addObject("user", userForSession);
        if (listUpdate != null) {
            model.addObject("items", listUpdate);
        }
        return model;
    }
}
