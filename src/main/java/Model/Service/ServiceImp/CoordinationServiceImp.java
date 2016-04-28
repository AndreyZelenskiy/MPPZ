package Model.Service.ServiceImp;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.CoordinationResultRepository;
import Model.Repository.MethodicsRepository;
import Model.Repository.QueriesRepository;
import Model.Service.CoordinatorService;
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


    public QueriesEntity setResult(String name, CoordinationResultsEntity resultsEntity) {
        List<QueriesEntity> queriesEntity = repository.findAll();
        for(QueriesEntity query: queriesEntity){
            if(query.getMethod().getNameOfMethodic().equals(name)){
                query.setCoordinationResult(resultsEntity);
                repository.save(query);
                return query;
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
