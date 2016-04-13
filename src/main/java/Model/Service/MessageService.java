package Model.Service;

import Model.Entity.ClientsEntity;
import Model.Entity.CoordinationResultsEntity;
import Model.Entity.JucticeResultEntity;

/**
 * Created by talizorah on 16.13.4.
 */
public interface MessageService {
    void sendCoordResult(CoordinationResultsEntity entity, DeveloperService service);
    void sendJusticeResult(JucticeResultEntity entity, DeveloperService service);
}
