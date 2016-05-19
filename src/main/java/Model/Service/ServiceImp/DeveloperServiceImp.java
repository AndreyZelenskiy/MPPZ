package Model.Service.ServiceImp;

import Model.Entity.*;
import Model.Repository.ClientsRepository;
import Model.Repository.MethodicsRepository;
import Model.Repository.RegistrRepository;
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

    @Inject
    RegistrRepository registrRepository;

    public String createMethod(String name, String type, String text, String dev) {
        MethodicsEntity entity = new MethodicsEntity();
        if(registrRepository.findEntityByMethod_NameOfMethodic(name).size() == 0) {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            entity.setNameOfMethodic(name);
            entity.setCreatingDate(sqlDate);
            entity.setMethodicText(text);
            entity.setMethodType(MethodType.valueOf(type).ordinal());
            entity.setAuthor(clientsRepository.getClientsEntityByLogin(dev).get(0));
            methodicsRepository.save(entity);
            queryService.createQuery(entity, TypeOfQuery.ADD);
            return "Створення було успішним";
        }
        return "Така назва вже використовується";
    }

    public String editMethod(String name, String type, String text, ClientsEntity developer){
        MethodicsEntity method = new MethodicsEntity();
        if(registrRepository.findEntityByMethod_NameOfMethodic(name).size() != 0){
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
            method.setAuthor(developer);
            method.setNameOfMethodic(name);
            method.setCreatingDate(sqlDate);
            method.setMethodicText(text);
            method.setMethodType(MethodType.valueOf(type).ordinal());
            methodicsRepository.save(method);
            queryService.createQuery(method, TypeOfQuery.EDIT);
            return "Запит на редагування успішно створено";
        }else return "Такої назви немає в реєстрі";
    }

    public MethodicsEntity addMethod(String name, String text) {
        if(methodicsRepository.getMethodicByNameOfMethodic(name).size() != 0){
            return null;
        }else{
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
