package Model.Service;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

/**
 * Created by talizorah on 16.13.4.
 */
//@Service
public interface DeveloperService {
    MethodicsEntity addMethod(String name, String text);
    boolean editMethod(String name, String newText);
    boolean deleteMethod(String name);
    void checkResults(MethodicsEntity entity);
    void getMessage(String result);

    String createMethod(MethodicsEntity entity);

}
