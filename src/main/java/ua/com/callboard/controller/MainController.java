package ua.com.callboard.controller;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.callboard.instance.Item;
import ua.com.callboard.service.MainService;
import ua.com.callboard.user.UserForSession;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest req) {

        /**
         *  Get login and category for filter, if null return all items.
         */
        List<Item> tmpitems = new LinkedList<>();
        String category = req.getParameter("category");
        String login = req.getParameter("login");
        tmpitems = mainService.filterMain(login, category);
        if (tmpitems != null) {
            req.getSession().setAttribute("items", tmpitems);
        }
        ModelAndView model = new ModelAndView("main");
        model.addObject("isLogin", mainService.isLogin((UserForSession) req.getSession().getAttribute("user")));
        model.addObject("items", tmpitems);
        return model;
    }
}
