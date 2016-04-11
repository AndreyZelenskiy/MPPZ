package Model.Repository;

import Model.Entity.MethodicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xoll on 11.04.16.
 */
public interface MethodicsRepository extends JpaRepository<MethodicsEntity, Integer>{
    MethodicsEntity getMethodicByNameOfMethodic(String name);
}
