package Model.Service;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;

/**
 * Created by talizorah on 16.13.4.
 */
public interface PackageService {
    void createPackage
            (MethodicsEntity methodicsEntity,
             CoordinationResultsEntity entity,
             TypeOfQuery typeOfQuery,
             String review);
}
