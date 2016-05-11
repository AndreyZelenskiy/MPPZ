package Model.Repository;

import Model.Entity.MethodicsEntity;
import Model.Entity.PackagesEntity;
import Model.Entity.RegistrEntity;
import org.hibernate.annotations.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by xoll on 12.04.16.
 */
public interface RegistrRepository extends JpaRepository<RegistrEntity, Integer>{
    List<RegistrEntity> findEntityByMethod_NameOfMethodic(String name);
}
