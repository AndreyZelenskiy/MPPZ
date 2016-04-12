package Model.Repository;

import Model.Entity.CoordinationResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xoll on 12.04.16.
 */
public interface CoordinationResultRepository extends JpaRepository<CoordinationResultsEntity, Integer> {
    List<CoordinationResultsEntity> getCoordinationResultByResultText(String text);
}
