package Controller;

import Model.Entity.ClientsEntity;
import Model.Entity.Role;
import Model.Repository.ClientsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by talizorah on 16.27.4.
 */
@Controller
@RequestMapping("/admin")
public class PrivateRoomController {

    private String USER_NAME = "username";
    @Inject
    ClientsRepository clientsRepository;

    @RequestMapping(value = "private")
    public String open(ModelMap map){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        ClientsEntity entity = clientsRepository.findOneByLogin(name);
        map.put(USER_NAME, name);
        switch (entity.getRoles().get(0)){
            case DEVELOPER:
                return "devprivatepage";
            case COORDINATION_WORKER:
                return "coordprivatepage";
            case JUCTICE_WORKER:
                return "justiceprivatepage";
        }
        return null;
    }
}
