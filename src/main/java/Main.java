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
        ClientsEntity client = clientRepository.getClientsEntityByLogin("admin");
        client.setRoles(Arrays.asList(Role.COORDINATION_WORKER, Role.DEVELOPER));
        clientRepository.save(client);
    }
}