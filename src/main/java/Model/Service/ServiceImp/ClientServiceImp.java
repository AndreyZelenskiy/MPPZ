package Model.Service.ServiceImp;

import Model.Entity.ClientsEntity;
import Model.Entity.PackagesEntity;
import Model.Entity.Role;
import Model.Repository.ClientsRepository;
import Model.Service.ClientService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Ilias on 4/14/2016.
 */
@Service
public class ClientServiceImp implements ClientService {

    @Inject
    ClientsRepository clientsRepository;

    public boolean authorization(String login, String password) {
        ClientsEntity clientsEntity = clientsRepository.findOneByLogin(login);
        if(clientsEntity==null){
            return false;
        }
        if(clientsEntity.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean registration(String login, String password, String firstName, String secondName, List<Role> list) {
        ClientsEntity clientsEntity = clientsRepository.findOneByLogin(login);
        if(clientsEntity==null){
            ClientsEntity newClient = new ClientsEntity(login,password,firstName,secondName);
            newClient.setRoles(list);
            newClient.setMethodics(null);
            newClient.setCoordinationResults(null);
            newClient.setJucticeResultEntities(null);
            clientsRepository.save(newClient);
            return true;
        }
        else return false;
    }
}
