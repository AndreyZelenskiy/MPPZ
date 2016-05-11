package Model.Service.ServiceImp;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.CoordinationResultRepository;
import Model.Repository.MethodicsRepository;
import Model.Repository.QueriesRepository;
import Model.Service.CoordinatorService;
import Model.Service.PackageService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilias on 4/14/2016.
 */
@Service
public class CoordinationServiceImp implements CoordinatorService {

    @Inject
    QueriesRepository repository;

    @Inject
    PackageService packageService;

    public String setResult(String name, CoordinationResultsEntity resultsEntity, String act) {
        List<QueriesEntity> queriesEntity = repository.findAll();
        for(QueriesEntity query: queriesEntity){
            if(query.getMethod().getNameOfMethodic().equals(name)){
                query.setCoordinationResult(resultsEntity);
                if(act.equals("confirm")) {
                    query.setComplete(true);
                    repository.save(query);
                    packageService.createPackage(query.getMethod(), resultsEntity, query.getType(), null);
                    return "Методики перевірена і відправлена Міністерству Юстицій України";
                }
                else{
                    query.setComplete(false);
                    repository.save(query);
                    return "Методика була відхилена";
                }
            }
        }
        return null;
    }

    public List<QueriesEntity> getUncheckedQueries() {
        List<QueriesEntity> list = repository.findAll();
        List<QueriesEntity> result = new ArrayList<QueriesEntity>();
        for(QueriesEntity query : list){
            if(query.getCoordinationResult() == null){
                result.add(query);
            }
        }
        return result;
    }


    public boolean checkQuery(QueriesEntity entity) {
        if(entity.getIdQuery()<=0 && entity.getCoordinationResult()!= null && entity.getMethod() != null
                && entity.getType()!=null){
            return true;
        }
        else return false;
    }

}
