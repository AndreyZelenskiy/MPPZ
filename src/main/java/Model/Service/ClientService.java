package Model.Service;

import Model.Entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by talizorah on 16.13.4.
 */
//@Service
public interface ClientService  {
    boolean authorization
            (String login, String password);
    boolean registration
            (String login, String password, String firstName, String secondName, List<Role> list);
}
