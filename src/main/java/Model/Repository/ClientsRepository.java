package Model.Repository;

import Model.Entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
public interface ClientsRepository extends JpaRepository<ClientsEntity, Integer> {
    List<ClientsEntity> getClientsEntityByLogin(String login);
}
