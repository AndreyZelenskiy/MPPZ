import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.PackagesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.CoordinationResultRepository;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
import Model.Service.PackageService;
import Model.Service.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by talizorah on 16.14.4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-root.xml"})
public class PackageServiceImpTest {

    @Inject
    QueryService queryService;

    @Inject
    DeveloperService developerService;

    @Inject
    MethodicsRepository methodicsRepository;

    @Inject
    PackageService packageService;

    @Inject
    CoordinationResultRepository resultRepository;

    @Test
    public void testCreatePackage() {
        String methodName = "Meth1";
        developerService.addMethod(methodName, "Text");
        List<MethodicsEntity> methodicsEntityList =
                methodicsRepository.getMethodicByNameOfMethodic(methodName);
        CoordinationResultsEntity coordinationResultsEntity = new CoordinationResultsEntity();
        coordinationResultsEntity.setResultText("someTest");
        resultRepository.save(coordinationResultsEntity);
        packageService.createPackage(methodicsEntityList.get(0), coordinationResultsEntity,
                TypeOfQuery.ADD, "someReview");
    }
}
