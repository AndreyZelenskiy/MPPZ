package Controller;

import Model.Entity.MethodicsEntity;
import Model.Service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.naming.Binding;
import javax.validation.Valid;

/**
 * Created by talizorah on 16.19.4.
 */
@Controller
@RequestMapping("admin/dev")
@SessionAttributes(value = {"MethodicsEntity"})
public class MethodicController {

    @Inject
    DeveloperService developerService;


    @ModelAttribute("MethodicsEntity")
    public MethodicsEntity methodicModel(){
        return new MethodicsEntity();
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCreationPage(ModelMap map){
        return "methodicCreationPage";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMethodic(@Valid @ModelAttribute("MethodicsEntity")
                                             MethodicsEntity methodicsEntity,
                                 BindingResult result, ModelMap map){
        if(result.hasErrors())
            return "methodicCreationPage";
        String str = developerService.createMethod(methodicsEntity);
        map.put("createResult", str);
        return "methodicCreationPage";
    }

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public String showQueries(ModelMap mav){

        return "queryViewPage";
    }


}
