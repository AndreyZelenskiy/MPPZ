import Model.Entity.*;
import Model.Repository.ClientsRepository;
import Model.Repository.MethodicsRepository;
import Model.Repository.PackagesRepository;
import Model.Repository.QueriesRepository;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by talizorah on 16.13.4.
 */

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepositoryTest {
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"bogdan", "admin", "firstName", "secondName", "review1"},
                {"help", "admin", "firstName", "secondName", "review2"},
                {"test", "admin", "firstName", "secondName", "review3"}
        });
    }
    private String login, password, name, surname, review;
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-root.xml");
    private ClientsRepository clientsRepository;
    private MethodicsRepository methodicsRepository;
    private PackagesRepository packagesRepository;
    private QueriesRepository queriesRepository;
    public RepositoryTest(String login, String password, String name, String surname, String review){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.review = review;
        this.clientsRepository = context.getBean(ClientsRepository.class);
        this.methodicsRepository = context.getBean(MethodicsRepository.class);
        this.packagesRepository = context.getBean(PackagesRepository.class);
        this.queriesRepository = context.getBean(QueriesRepository.class);
    }


    @Test
    public void get002testGetUserFromDatabase(){
        List<ClientsEntity> clientsEntityList = this.clientsRepository.getClientsEntityByLogin(this.login);
        System.out.println(clientsEntityList.get(0).toString());
    }

    @Test
    @Ignore
    public void testCreateUsers(){
        ClientsEntity client = new ClientsEntity(this.login, this.password, this.name, this.surname);
        client.setRoles(Arrays.asList(Role.DEVELOPER));
        this.clientsRepository.save(client);
    }

    @Test
    public void get001testCreateUserWithMethodic(){
        ClientsEntity client = new ClientsEntity(this.login, this.password, this.name, this.surname);
        client.setRoles(Arrays.asList(Role.DEVELOPER));
        java.sql.Date date = new java.sql.Date(23123);
        MethodicsEntity methodic = new MethodicsEntity(this.login, "text", date);
        client.setMethodics(Arrays.asList(methodic));
        this.clientsRepository.save(client);
    }


    @Test
    public void get004testCreatePackageWithMethodic(){
        PackagesEntity packagesEntity = new PackagesEntity();
        List<MethodicsEntity> methodicsEntityList = methodicsRepository.getMethodicByNameOfMethodic(this.login);
        packagesEntity.setMethod(methodicsEntityList.get(0));
        packagesEntity.setReview(this.review);
        packagesRepository.save(packagesEntity);
    }


    @Test
    public void get006testDeletePackage(){
        List<PackagesEntity> packagesEntityList = packagesRepository.getPackgesEntityByReview(this.review);
        packagesRepository.delete(packagesEntityList.get(0));
    }

    @Test
    public void get007testDeleteUsers(){
        List<ClientsEntity> clientsEntityList = clientsRepository.getClientsEntityByLogin(login);
        clientsRepository.delete(clientsEntityList.get(0));
    }

    @Test
    public void get003testCreateQuery(){
        QueriesEntity queriesEntity = new QueriesEntity();
        queriesEntity.setMethod(methodicsRepository.getMethodicByNameOfMethodic(this.login).get(0));
        queriesEntity.setType(TypeOfQuery.ADD);
        queriesRepository.save(queriesEntity);
    }

    @Test
    public void get005testDeleteQuery(){
        List<QueriesEntity> list = queriesRepository.getQueriesByType(TypeOfQuery.ADD);
        for(QueriesEntity entity: list){
            queriesRepository.delete(entity);
        }
    }

}

