package Model.Service;

import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;

/**
 * Created by talizorah on 16.13.4.
 */
public interface CoordinatorService {
    void getUncheckedQueries();
    void checkQuery(QueriesEntity entity);
    String getReview(MethodicsEntity entity);
}
