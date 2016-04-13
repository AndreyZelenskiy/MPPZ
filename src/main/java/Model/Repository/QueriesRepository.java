package Model.Repository;

import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xoll on 11.04.16.
 */
public interface QueriesRepository extends JpaRepository<QueriesEntity, Integer> {
    QueriesEntity getQueriesByIdQuery(int id);
    List<QueriesEntity> getQueriesByType(TypeOfQuery typeOfQuery);
}
