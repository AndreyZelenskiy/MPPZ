package Model.Repository;

import Model.Entity.PackagesEntity;
import Model.Entity.RegistrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xoll on 12.04.16.
 */
public interface RegistrRepository extends JpaRepository<RegistrEntity, Integer>{
}
