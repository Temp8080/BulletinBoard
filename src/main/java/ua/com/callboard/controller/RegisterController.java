/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.callboard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.callboard.service.UserService;
import ua.com.callboard.user.UserConverter;

@Controller
public class RegisterController {

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest req) {
        String login = req.getParameter("login");
        if (login == null) {
            ModelAndView model = new ModelAndView("reg");
            return model;
        } else {
            ModelAndView model = new ModelAndView("info");
            if (userService.getUserByLogin(login) == null) {
                userService.addUser(userConverter.userToRegister(
                        login,
                        req.getParameter("pass"),
                        req.getParameter("phone")));
                model.addObject("info", "Register success!!!");
            } else {
                model.addObject("info", "Login already used.");
            }
            return model;
        }
    }
}
