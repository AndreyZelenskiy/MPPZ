package Model.Service.ServiceImp;

import Model.Entity.MethodicsEntity;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by talizorah on 16.14.4.
 */
@Service
public class DeveloperServiceImp implements DeveloperService {

    @Inject
    MethodicsRepository methodicsRepository;

    public String createMethod(MethodicsEntity entity) {
        if(methodicsRepository.getMethodicByNameOfMethodic(entity.getNameOfMethodic()).size() == 0){
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                entity.setCreatingDate(sqlDate);
                methodicsRepository.save(entity);
                return "Success";
        }
        return "Such name is already in use";
    }

    public MethodicsEntity addMethod(String name, String text) {
        if(methodicsRepository.getMethodicByNameOfMethodic(name).size() != 0){
            return null;
        }
        else{
            MethodicsEntity methodicsEntity = new MethodicsEntity();
            methodicsEntity.setNameOfMethodic(name);
            methodicsEntity.setMethodicText(text);
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            methodicsEntity.setCreatingDate(sqlDate);
            methodicsRepository.save(methodicsEntity);
            return methodicsEntity;
        }
    }

    public boolean editMethod(String name, String newText){
        MethodicsEntity methodicsEntity =
                methodicsRepository.getMethodicByNameOfMethodic(name).get(0);
        if(methodicsEntity == null){
            return false;
        }
        else{
            methodicsEntity.setMethodicText(newText);
            methodicsRepository.save(methodicsEntity);
            return true;
        }
    }

    public boolean deleteMethod(String name){
        MethodicsEntity methodicsEntity =
                methodicsRepository.getMethodicByNameOfMethodic(name).get(0);
        if(methodicsEntity == null){
            return false;
        }
        else {
            methodicsRepository.delete(methodicsEntity);
            return true;
        }
    }

    public void checkResults(MethodicsEntity entity) {

    }

    public void getMessage(String result) {

    }
}
