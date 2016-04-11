package Model.Repository;

import Model.Entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xoll on 11.04.16.
 */
public interface ClientsRepository extends JpaRepository<ClientsEntity, Integer> {
    ClientsEntity getClientsEntityByLogin(String login);
}
