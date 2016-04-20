package Controller;

import Model.Service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by talizorah on 16.19.4.
 */
@Controller
@RequestMapping("/login")
public class AuthorizationController {

    @Inject
    ClientService clientService;

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public String login(@RequestParam("login")String login,
                        @RequestParam("password") String password){
        if(clientService.authorization(login, password)){
            return "redirect:/admin/methodic/show";
        }
        return "redirect:/";
    }
}
