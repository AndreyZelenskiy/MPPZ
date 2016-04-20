import Model.Entity.Role;
import Model.Service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by talizorah on 16.14.4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-root.xml"})
public class ClientServiceImpTest {
    @Inject
    ClientService clientService;

    @Test
    public void testClientRegistration(){
        String name = "bogdan";
        String password = "bogdan";
        String firstname = "name";
        String secondName = "second";
        List<Role> list = new ArrayList<Role>(Arrays.asList(Role.DEVELOPER, Role.JUCTICE_WORKER));
        assertTrue(clientService.registration(name, password, firstname, secondName, list));
    }

    @Test
    public void testClientAuthorization(){
        String name = "Admin";
        String password = "Admin";
        assertTrue(clientService.authorization(name, password));
    }

}
