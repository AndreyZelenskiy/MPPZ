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

    String createMethod(String name, String type, String text, String dev);

}
