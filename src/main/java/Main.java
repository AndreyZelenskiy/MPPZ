import Model.Entity.*;
import Model.Repository.ClientsRepository;
import Model.Repository.CoordinationResultRepository;
import Model.Repository.MethodicsRepository;
import Model.Repository.QueriesRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-root.xml");
        QueriesRepository repository = context.getBean(QueriesRepository.class);
        QueriesEntity query = repository.getQueriesByIdQuery(2);

        ClientsEntity developer = context.getBean(ClientsRepository.class).getClientsEntityByLogin("admin");
        for (CoordinationResultsEntity resultsEntity : developer.getCoordinationResults()) {
            System.out.println(resultsEntity);
        }
    }
}
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

