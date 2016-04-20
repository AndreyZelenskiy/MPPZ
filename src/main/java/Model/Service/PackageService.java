package Model.Service;

import Model.Entity.*;

/**
 * Created by talizorah on 16.13.4.
 */
public interface PackageService {
    PackagesEntity createPackage
            (MethodicsEntity methodicsEntity,
             CoordinationResultsEntity entity,
             TypeOfQuery typeOfQuery,
             String review);
}
