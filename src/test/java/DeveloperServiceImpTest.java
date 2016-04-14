import Model.Service.DeveloperService;
import Model.Service.ServiceImp.DeveloperServiceImp;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

/**
 * Created by talizorah on 16.14.4.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-root.xml"})
public class DeveloperServiceImpTest {

    @Inject
    DeveloperService developerService;

    @Test
    public void testAddMethodic(){
        String name = "name";
        String text = "text";
        assertTrue(developerService.addMethod(name, text));
    }

    @Test
    public void testEditMethodic(){
        String name = "name";
        String newText = "newtext";
        assertTrue(developerService.editMethod(name, newText));
    }

    @Test
    public void testDeleteMethodic(){
        String name = "name";
        assertTrue(developerService.deleteMethod(name));
    }
}
