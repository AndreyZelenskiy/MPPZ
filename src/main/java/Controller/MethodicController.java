package Controller;

import Model.Entity.MethodicsEntity;
import Model.Service.DeveloperService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by talizorah on 16.19.4.
 */
@Controller
@RequestMapping("admin/dev")
public class MethodicController {

    @Inject
    DeveloperService developerService;



    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCreationPage(ModelMap map){
        return "methodicCreationPage";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMethodic(@RequestParam(value = "methodName")String nameMethodic,
                                 @RequestParam(value = "methodText")String text,
                                 @RequestParam(value = "methodType")String type,
                                 ModelMap map){
        String str;
        if(nameMethodic.length() < 3){
            str = "Мінімальний розмір назви методики - 3 символи";
        }
        else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            str = developerService.createMethod(nameMethodic, type,
                    text, name);
        }
        map.put("createResult", str);
        return "methodicCreationPage";
    }

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public String showQueries(ModelMap mav){

        return "queryViewPage";
    }


}
