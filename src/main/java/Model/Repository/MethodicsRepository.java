package Model.Repository;

import Model.Entity.MethodicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
public interface MethodicsRepository extends JpaRepository<MethodicsEntity, Integer>{
    List<MethodicsEntity> getMethodicByNameOfMethodic(String name);
    List<MethodicsEntity> findMethodicByNameOfMethodic(String name);
}

