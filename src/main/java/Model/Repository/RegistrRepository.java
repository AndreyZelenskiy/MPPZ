package Model.Repository;

import Model.Entity.PackagesEntity;
import Model.Entity.RegistrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xoll on 12.04.16.
 */
public interface RegistrRepository extends JpaRepository<RegistrEntity, Integer>{
}
