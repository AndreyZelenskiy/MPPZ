package Model.Service;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;

/**
 * Created by talizorah on 16.13.4.
 */
public interface DeveloperService {
    void addMethod();
    void editMethod();
    void deleteMethod();
    void checkResults(MethodicsEntity entity);
    void getMessage(String result);
}
