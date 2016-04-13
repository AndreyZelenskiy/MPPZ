import Model.Entity.*;
import Model.Repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by xoll on 11.04.16.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-root.xml");

        ClientsRepository repository = context.getBean(ClientsRepository.class);
        ClientsEntity client = repository.getClientsEntityByLogin("admin");
        RolesEntity role = new RolesEntity("Second role");
        client.setRoles(Arrays.asList(client.getRoles().get(0), role));

        repository.save(client);
    }
}
//
//    PackagesRepository repository = context.getBean(PackagesRepository.class);
//    PackagesEntity packagesEntity = repository.getPackgesEntityByReview("Sample review");
//
//    JucticeResultEntity result = packagesEntity.getJucticeResult();
//result.setDevelopers(Arrays.asList(packagesEntity.getMethod().getDevelopers().get(0)));
//        packagesEntity.getMethod().getDevelopers().get(0).setJucticeResultEntities(Arrays.asList(result));
//
//        repository.save(packagesEntity);
//    MethodicsRepository repo = context.getBean(MethodicsRepository.class);
//
//    MethodicsEntity method = repo.getMethodicByNameOfMethodic("Test methodic");
//
//    CoordinationResultsEntity coordinationResultsEntity = new CoordinationResultsEntity("Sample text");
//
//    QueriesEntity queriesEntity = new QueriesEntity();
//queriesEntity.setMethod(method);
//        queriesEntity.setCoordinationResult(coordinationResultsEntity);
//        coordinationResultsEntity.setQuery(queriesEntity);
//
//        TypesOfQueriesEntity type = new TypesOfQueriesEntity();
//        type.setType("Sample type");
//        ArrayList<QueriesEntity> list = new ArrayList<QueriesEntity>();
//        list.add(queriesEntity);
//        type.setQueries(list);
//
//        queriesEntity.setType(type);
//
//        QueriesRepository queriesRepository = context.getBean(QueriesRepository.class);
//        queriesRepository.save(queriesEntity);

//    ClientsRepository repository = context.getBean(ClientsRepository.class);
//
//    ClientsEntity client = new ClientsEntity("admin", "admin", "Admin", "Surname");
//    RolesEntity rolesEntity = new RolesEntity("Test");
//    ArrayList<RolesEntity> list = new ArrayList<RolesEntity>();
//    list.add(rolesEntity);
//        client.setRoles(list);
//        ArrayList<ClientsEntity> clients = new ArrayList<ClientsEntity>();
//        clients.add(client);
//        rolesEntity.setClients(clients);
//
//        repository.save(client);

