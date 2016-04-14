package Model.Service;

import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;

/**
 * Created by talizorah on 16.13.4.
 */

public interface QueryService {
    void createQuery(MethodicsEntity entity, TypeOfQuery typeOfQuery);
}
