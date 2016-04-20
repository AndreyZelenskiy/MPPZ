import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.PackagesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
import Model.Service.JusticeService;
import Model.Service.PackageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by talizorah on 16.15.4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-root.xml"})
public class RegisterServiceImpTest {

    @Inject
    JusticeService justiceService;

    @Inject
    DeveloperService developerService;

    @Inject
    PackageService packageService;

    @Inject
    MethodicsRepository methodicsRepository;


    @Test
    public void testAddToRegister(){
        String methodName = "Meth1";
        developerService.addMethod(methodName, "Text");
       // List<MethodicsEntity> methodicsEntityList =
        //        methodicsRepository.getMethodicByNameOfMethodic(methodName);

        List<MethodicsEntity> methodicsEntityList = methodicsRepository.findMethodicByNameOfMethodic(methodName);
        assertNotEquals(methodicsEntityList.size(), 0);
        /*CoordinationResultsEntity coordinationResultsEntity = new CoordinationResultsEntity();
        coordinationResultsEntity.setResultText("someTest");
        //resultRepository.save(coordinationResultsEntity);
        PackagesEntity entity = packageService.createPackage(methodicsEntityList.get(0), coordinationResultsEntity,
                TypeOfQuery.ADD, "someReview");
        justiceService.addToRegister(entity);*/
    }
}
