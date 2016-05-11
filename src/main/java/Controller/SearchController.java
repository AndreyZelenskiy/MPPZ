package Controller;

import Model.Entity.MethodType;
import Model.Entity.MethodicsEntity;
import Model.Entity.RegistrEntity;
import Model.Repository.RegistrRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by talizorah on 16.9.5.
 */
@Controller
@RequestMapping("/search/")
public class SearchController {
    @Inject
    RegistrRepository registrRepository;

    @RequestMapping(value = "found", method = RequestMethod.POST)
    public String getFromRegistr(@RequestParam(value = "formDoor[]", required = false)String [] checkBoxData,
                                 @RequestParam("methodName")String methodName,
                                 ModelMap map){
        List<RegistrEntity> result = new ArrayList<RegistrEntity>();
        List<RegistrEntity> checkBox = registrRepository.findAll();
        if(checkBoxData == null){
            result = checkBox;
        }
        else{
            for(RegistrEntity registrEntity: checkBox) {
                for (String methodType : checkBoxData) {
                    if (registrEntity.getMethod().getMethodType() == MethodType.valueOf(methodType).ordinal()) {
                        result.add(registrEntity);
                    }
                }
            }
        }
        if(methodName.length() > 0){
            List<RegistrEntity> nameResult = new ArrayList<RegistrEntity>();
            for(RegistrEntity registrEntity: result){
                if((registrEntity.getMethod().getNameOfMethodic().equals(methodName))){
                    nameResult.add(registrEntity);
                }
            }
            result = nameResult;
        }
        List<MethodicsEntity> methodicsEntityList = new ArrayList<MethodicsEntity>();
        for(RegistrEntity registrEntity: result){
            methodicsEntityList.add(registrEntity.getMethod());
        }
        map.put("result", methodicsEntityList);
        map.put("types", MethodType.values());
        return "searchpage";
    }
}
