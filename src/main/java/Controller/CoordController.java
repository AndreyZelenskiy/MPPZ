package Controller;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
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
@SessionAttributes(value = {"CoordinationResultsEntity"})
public class CoordController {

    @Inject
    CoordinatorService coordinatorService;

    @ModelAttribute("CoordinationResultsEntity")
    public CoordinationResultsEntity methodicModel(){
        return new CoordinationResultsEntity();
    }

    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    public String getQueries(ModelMap map){
        map.put("queries", coordinatorService.getUncheckedQueries());
        return "coordQueriespage";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPack(@Valid @ModelAttribute("CoordinationResultsEntity")
            CoordinationResultsEntity entity, BindingResult result,
                             @RequestParam("queryName")String name,
            ModelMap map){
        if(result.hasErrors()){
            return "coordQueriespage";
        }
        coordinatorService.setResult(name, entity);
        return "coordQueriespage";
    }
}
