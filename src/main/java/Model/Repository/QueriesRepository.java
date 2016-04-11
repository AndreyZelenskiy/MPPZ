package Model.Repository;

import Model.Entity.QueriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xoll on 11.04.16.
 */
public interface QueriesRepository extends JpaRepository<QueriesEntity, Integer> {
    QueriesEntity getQueriesByIdQuery(int id);
}
