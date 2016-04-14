import Model.Entity.MethodicsEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.MethodicsRepository;
import Model.Service.DeveloperService;
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
public class QueryServiveImpTest {

    @Inject
    QueryService queryService;

    @Inject
    DeveloperService developerService;

    @Inject
    MethodicsRepository methodicsRepository;

    @Test
    public void testCreateQuery(){
        String methodName = "Meth";
        developerService.addMethod(methodName, "Text");
        List<MethodicsEntity> methodicsEntityList =
                methodicsRepository.getMethodicByNameOfMethodic(methodName);
        queryService.createQuery(methodicsEntityList.get(0), TypeOfQuery.ADD);
    }
}
