package ua.com.callboard.controller;


import ua.com.callboard.instance.Item;
import ua.com.callboard.service.MainService;
import ua.com.callboard.service.ItemService;
import ua.com.callboard.service.UserService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.callboard.user.UserConverter;
import ua.com.callboard.user.UserForSession;

@Controller
public class LoginController {

    @Autowired
    private MainService mainService;

    @Autowired
    @Qualifier(value = "itemServ")
    private ItemService itemService;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest req) {

        /**
         *  Will be logged out, if EXIT not null.
         */
        if (req.getParameter("exit") != null) {
            req.getSession().removeAttribute("user");
            ModelAndView model = new ModelAndView("main");
            List<Item> items = itemService.getItems();
            model.addObject("isLogin", mainService.isLogin((UserForSession) req.getSession().getAttribute("user")));
            model.addObject("items", items);
            return model;
        } else {
            if (req.getParameter("login") == null) {
                ModelAndView model = new ModelAndView("login");
                return model;
            } else {
                ModelAndView model = new ModelAndView("info");
                String login = req.getParameter("login");
                String pass = req.getParameter("pass");
                UserForSession userForSession = null;

                /**
                 *  Get User by Login.
                 */
                try {
                    userForSession = userConverter.userSession(userService.getUserByLogin(login));
                } catch (NullPointerException e) {
                    model.addObject("info", "User is not register");
                }
                if (userForSession == null) {
                    model.addObject("info", "User is not register");
                } else {
                    /**
                    * If login taken from db correct, check password and send User to session, log in.
                    */
                    if (userForSession.getPass().equals(pass)) {
                        HttpSession s = req.getSession();
                        s.setAttribute("user", userForSession);
                        model.addObject("info", "You are logged in");
                    } else {
                        model.addObject("info", "Incorrect password");
                    }
                }
                return model;
            }
        }
    }
}
