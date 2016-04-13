import Model.Entity.*;
import Model.Repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by xoll on 11.04.16.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-root.xml");
        QueriesRepository queryRepository = context.getBean(QueriesRepository.class);
        ClientsRepository clientRepository = context.getBean(ClientsRepository.class);
        QueriesEntity query = queryRepository.getQueriesByIdQuery(1);

        PackagesRepository packageRepository = context.getBean(PackagesRepository.class);
        PackagesEntity pack = new PackagesEntity();
        pack.setMethod(clientRepository.getClientsEntityByLogin("admin").getMethodics().get(0));
        pack.setCoordinationResult(query.getCoordinationResult());
        pack.setReview("Sample review");
        pack.setType(TypeOfQuery.ADD);
    }
}