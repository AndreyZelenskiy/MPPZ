package Model.Service.ServiceImp;

import Model.Entity.MethodType;
import Model.Entity.MethodicsEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.ClientsRepository;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
import Model.Service.QueryService;
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

    @Inject
    ClientsRepository clientsRepository;

    @Inject
    QueryService queryService;

    public String createMethod(String name, String type, String text, String dev) {
        MethodicsEntity entity = new MethodicsEntity();
        if(methodicsRepository.getMethodicByNameOfMethodic(name).size() == 0){
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            entity.setNameOfMethodic(name);
            entity.setCreatingDate(sqlDate);
            entity.setMethodicText(text);
            entity.setMethodType(MethodType.valueOf(type).ordinal());
            entity.setAuthor(clientsRepository.getClientsEntityByLogin(dev));
            methodicsRepository.save(entity);
            queryService.createQuery(entity, TypeOfQuery.ADD);
            return "Створення було успішним";
        }
        return "Така назва вже використовується";
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
}
