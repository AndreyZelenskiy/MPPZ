package Controller;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.JucticeResultEntity;
import Model.Entity.MethodType;
import Model.Entity.PackagesEntity;
import Model.Repository.JusticeResultRepository;
import Model.Repository.PackagesRepository;
import Model.Service.JusticeService;
import Model.Service.PackageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by talizorah on 16.4.5.
 */
@Controller
@RequestMapping("/admin/just")
@SessionAttributes(value = {"JucticeResultEntity"})
public class JusticeController {


    @ModelAttribute("JucticeResultEntity")
    public JucticeResultEntity jucticeModel(){
        return new JucticeResultEntity();
    }

    @Inject
    JusticeService justiceService;

    @Inject
    PackagesRepository packagesRepository;

    @Inject
    JusticeResultRepository resultRepository;

    private String resultText;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPackages(ModelMap map) {
        map.put("dataSource", justiceService.getUncheckedPackages());
        map.put("resultText", resultText);
        resultText = null;
        return "justicePackagesPage";
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public String confirmPackage(@Valid @ModelAttribute("JucticeResultEntity")
                                 JucticeResultEntity resultEntity, BindingResult result,
                                 @RequestParam("queryName")String name,
                                 @RequestParam("action")String action,
                                 ModelMap map){
        if(result.hasErrors()){
            resultText = "Поле ОЦІНКА повинне бути заповненим";
            return "redirect:/admin/just/show";
        }
        if(resultEntity.getResultText().length() < 1){
            resultText = "Поле ОЦІНКА повинне бути заповненим";
        }
        else{
            resultRepository.save(resultEntity);
            PackagesEntity entity = justiceService.getPackage(name);
            entity.setReview(resultEntity.getResultText());
            packagesRepository.save(entity);
            if(action.equals("confirm")){
                resultText = justiceService.addToRegister(justiceService.getPackage(name), resultEntity);
            }
            else{
                resultText = "Методика була відхилена рішенням Міністерства Юстицій України";
            }
        }
        return "redirect:/admin/just/show";
    }


}
