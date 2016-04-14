package Model.Service;

import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;

import java.util.List;

/**
 * Created by talizorah on 16.13.4.
 */
public interface CoordinatorService {
    List<QueriesEntity> getUncheckedQueries();
    boolean checkQuery(QueriesEntity entity);
//    String getReview(MethodicsEntity entity);
}
