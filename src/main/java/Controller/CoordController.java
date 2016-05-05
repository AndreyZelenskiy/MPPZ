package Controller;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodType;
import Model.Entity.MethodicsEntity;
import Model.Repository.CoordinationResultRepository;
import Model.Repository.MethodicsRepository;
import Model.Service.CoordinatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by talizorah on 16.28.4.
 */
@Controller
@RequestMapping("/admin/coord")
public class CoordController {
    private String resultText = null;
    @Inject
    CoordinatorService coordinatorService;

    @Inject
    CoordinationResultRepository resultRepository;

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public String getQueries(ModelMap map){
        map.put("queries", coordinatorService.getUncheckedQueries());
        map.put("types", MethodType.values());
        map.put("resultText", resultText);
        resultText = null;
        return "coordQueriespage";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPack(@RequestParam("resultText")String text,
                             @RequestParam("queryName")String name,
                             @RequestParam("action")String action,
            ModelMap map){
        CoordinationResultsEntity entity = new CoordinationResultsEntity();
        entity.setResultText(text);
        //resultRepository.save(entity);
        if(entity.getResultText().length() < 3){
            resultText = "Поле ОЦІНКА повинне бути заповненим";
        }
        else {
            resultText = coordinatorService.setResult(name, entity, action);
        }
        resultRepository.save(entity);
        return "redirect:/admin/coord/queries";
    }
}
