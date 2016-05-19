package Controller;

import Model.Entity.*;
import Model.Repository.JusticeResultRepository;
import Model.Repository.PackagesRepository;
import Model.Repository.QueriesRepository;
import Model.Repository.RegistrRepository;
import Model.Service.JusticeService;
import Model.Service.PackageService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @Inject
    RegistrRepository registrRepository;

    @Inject
    QueriesRepository queriesRepository;

    private String resultText;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPackages(ModelMap map) {
        map.put("dataSource", justiceService.getUncheckedPackages());
        map.put("resultText", resultText);
        map.put("editableMethods", justiceService.getEditableMethods());
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
            if(action.equals("confirm")){
                entity.setComplete(true);
                entity.setReview(resultEntity.getResultText());
                if(entity.getType() == TypeOfQuery.EDIT){
                    resultText = justiceService.editRegister(entity.getMethod());
                }else resultText = justiceService.addToRegister(justiceService.getPackage(name), resultEntity);
            }
            else{
                entity.setComplete(false);
                resultText = "Методика була відхилена рішенням Міністерства Юстицій України";
            }
            packagesRepository.save(entity);
        }
        return "redirect:/admin/just/show";
    }

    @RequestMapping(value = "declined", method = RequestMethod.GET)
    public String showDeclined(ModelMap map){
        map.put("types", MethodType.values());
        map.put("queries", queriesRepository.findAll());
        List<QueriesEntity> resultCoord = new ArrayList<QueriesEntity>();
        for(QueriesEntity queriesEntity: queriesRepository.findAll()){
            if(!queriesEntity.isComplete() && queriesEntity.getCoordinationResult() != null)
                resultCoord.add(queriesEntity);
        }
        map.put("declinedCoord", resultCoord);
        List<PackagesEntity> resultJust = new ArrayList<PackagesEntity>();
        for(PackagesEntity packagesEntity: packagesRepository.findAll()){
            if(!packagesEntity.isComplete() && packagesEntity.getReview() != null)
                resultJust.add(packagesEntity);
        }
        map.put("declinedJust", resultJust);
        return "declinedPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteFromRegistr(ModelMap map){
        map.put("result", registrRepository.findAll());
        map.put("types", MethodType.values());
        return "deletePage";
    }

    @RequestMapping(value = "deleted", method = RequestMethod.POST)
    public String deleteFromRegistr(@RequestParam("queryName")String nameReg,
            ModelMap map){
        String str = justiceService.deleteFromRegistr(nameReg);
        return "redirect:/admin/just/delete";
    }

}
