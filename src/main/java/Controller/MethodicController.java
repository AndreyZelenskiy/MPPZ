package Controller;

import Model.Entity.ClientsEntity;
import Model.Entity.MethodType;
import Model.Entity.MethodicsEntity;
import Model.Repository.ClientsRepository;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Inject
    ClientsRepository clientRepository;

    @Inject
    MethodicsRepository methodicsRepository;

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

    @RequestMapping(value = "/mymethods", method = RequestMethod.GET)
    public String showAuthorsMethodics(ModelMap map){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        ClientsEntity developer = clientRepository.getClientsEntityByLogin(name).get(0);
        map.put("methods", methodicsRepository.findMethodicByAuthor(developer));
        map.put("types", MethodType.values());
        map.put("roles", developer.getRoles());
        return  "methodicsViewPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editMethodView(@RequestParam(value = "methodType")String methodType,
                                 @RequestParam(value = "methodName")String methodName,
                                 @RequestParam(value = "methodText")String methodText,
                                 ModelMap map){
        map.put("methodName", methodName);
        map.put("methodType", methodType);
        map.put("methodText", methodText);
        return "editMethodView";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editMethod(
            @RequestParam(value = "methodType")String methodType,
            @RequestParam(value = "methodName")String methodName,
            @RequestParam(value = "methodText")String methodText,
            ModelMap map){
        MethodicsEntity currentMethod = methodicsRepository.getMethodicByNameOfMethodic(methodName).get(0);
        if(methodText.length()==0 || methodType.length()==0){
            methodText = currentMethod.getMethodicText();
            methodType = String.valueOf(currentMethod.getMethodType());
        }else{
            String errorMessage = "";
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            ClientsEntity developer = clientRepository.getClientsEntityByLogin(name).get(0);
            errorMessage = developerService.editMethod(methodName, methodType, methodText, developer);
            map.put("createResult", errorMessage);
        }
        map.put("methodName", methodName);
        map.put("methodType", methodType);
        map.put("methodText", methodText);
        return "editMethodView";
    }

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public String showQueries(ModelMap mav){

        return "queryViewPage";
    }


}
