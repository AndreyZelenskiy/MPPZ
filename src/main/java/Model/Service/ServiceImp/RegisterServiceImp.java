package Model.Service.ServiceImp;

import Model.Entity.MethodicsEntity;
import Model.Entity.RegistrEntity;
import Model.Repository.RegistrRepository;
import Model.Service.RegisterService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by talizorah on 16.28.4.
 */
@Service
public class RegisterServiceImp implements RegisterService {
    @Inject
    RegistrRepository registrRepository;
    public List<MethodicsEntity> getMethodsFromRegister() {
        List<MethodicsEntity> methodicsEntityList = new ArrayList<MethodicsEntity>();
        for(RegistrEntity reg: registrRepository.findAll()){
            methodicsEntityList.add(reg.getMethod());
        }
        return methodicsEntityList;
    }
}
