package ua.com.callboard.controller;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.callboard.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.callboard.user.UserForSession;

@Controller
public class CreateController {

    @Autowired
    @Qualifier(value = "itemServ")
    private ItemService itemService;

    @RequestMapping("/create")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        /**
         *  Create new Item in callboard.
         */
        if (req.getParameter("name") == null) {
            ModelAndView model = new ModelAndView("create");
            return model;
        } else {
            itemService.addItem(itemService.createItem(
                    req.getParameter("name")
                    , Integer.parseInt(req.getParameter("price"))
                    , req.getParameter("about")
                    , req.getParameter("img")
                    , req.getParameter("smallimg")
                    , req.getParameter("category")
                    , ((UserForSession) req.getSession().getAttribute("user")).getLogin())
            );
            resp.sendRedirect("/main");
            return null;
        }
    }
}
