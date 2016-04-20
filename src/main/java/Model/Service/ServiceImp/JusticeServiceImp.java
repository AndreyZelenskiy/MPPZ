package Model.Service.ServiceImp;

import Model.Entity.MethodType;
import Model.Entity.PackagesEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.RegistrEntity;
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

    public List<PackagesEntity> getUncheckedPackages() {

        List<PackagesEntity> list = new ArrayList<PackagesEntity>();
        for(PackagesEntity tmp : packagesRepository.findAll()){
            if(tmp.getJucticeResult()==null){
                list.add(tmp);
            }
        }
        return list;
    }


    public boolean addToRegister(PackagesEntity entity) {
        RegistrEntity newInstance = new RegistrEntity();
        newInstance.setMethod(entity.getMethod());
        newInstance.setType(MethodType.FIRST);

        Date d = new Date();
        java.sql.Date date = new java.sql.Date(d.getTime());

        newInstance.setEndDate(date);
        newInstance.setEditDate(null);
        registrRepository.save(newInstance);
        return true;
    }
}
