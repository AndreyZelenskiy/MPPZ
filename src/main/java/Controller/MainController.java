package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by talizorah on 16.18.4.
 */

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(value = {"", "mainpage"}, method = RequestMethod.GET)
    public String mainpage(ModelAndView mav) {
        return "mainpage";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginpage(ModelAndView mav){
        return "loginpage";
    }

}
