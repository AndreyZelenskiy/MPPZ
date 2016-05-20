package Controller;

import Model.Entity.MethodType;
import Model.Repository.MethodicsRepository;
import Model.Repository.RegistrRepository;
import Model.Service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by talizorah on 16.26.4.
 *
 */
@Controller
@RequestMapping("/methods")
public class MethodicViewController {

    @Inject
    RegisterService registerService;

    @Inject
    RegistrRepository registrRepository;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMethodicsPage(ModelMap map){
        map.put("methods", registrRepository.findAll());
        map.put("types", MethodType.values());
        return "allMethodsPage";
    }

}
