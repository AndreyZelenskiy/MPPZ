package Model.Service.ServiceImp;

import Model.Entity.*;
import Model.Repository.JusticeResultRepository;
import Model.Repository.PackagesRepository;
import Model.Repository.RegistrRepository;
import Model.Service.JusticeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Ilias on 4/14/2016.
 */
@Service
public class JusticeServiceImp implements JusticeService {

    @Inject
    PackagesRepository packagesRepository;
    @Inject
    RegistrRepository registrRepository;

    @Inject
    JusticeResultRepository resultRepository;

    public PackagesEntity getPackage(String id) {
        List<PackagesEntity> entities = packagesRepository.findAll();
        for(PackagesEntity packagesEntity: entities){
            if(packagesEntity.getMethod().getIdMethodic() == Integer.valueOf(id)){
                return packagesEntity;
            }
        }
        return null;
    }

    public List<PackagesEntity> getUncheckedPackages() {

        List<PackagesEntity> list = new ArrayList<PackagesEntity>();
        for(PackagesEntity tmp : packagesRepository.findAll()){
            if(tmp.getReview() == null){
                list.add(tmp);
            }
        }
        return list;
    }


    public String deleteFromRegistr(String name) {
        RegistrEntity registrEntity = registrRepository.findOne(Integer.valueOf(name));
        registrRepository.delete(registrEntity);
        return "Методика успішно видалена";
    }

    public String addToRegister(PackagesEntity entity, JucticeResultEntity resultEntity) {
        RegistrEntity newInstance = new RegistrEntity();
        newInstance.setMethod(entity.getMethod());

        Date d = new Date();
        java.sql.Date date = new java.sql.Date(d.getTime());

        newInstance.setEndDate(date);
        newInstance.setEditDate(null);
        registrRepository.save(newInstance);
        return "Методика успішно внесена в реєстр";
    }
}
