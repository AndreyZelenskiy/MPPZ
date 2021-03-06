package Model.Service;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by talizorah on 16.13.4.
 */

public interface CoordinatorService {
    List<QueriesEntity> getUncheckedQueries();
    boolean checkQuery(QueriesEntity entity);
//    String getReview(MethodicsEntity entity);
    String setResult(String name, CoordinationResultsEntity resultsEntity, String action);

    List<MethodicsEntity> getEditableMethods();
}
