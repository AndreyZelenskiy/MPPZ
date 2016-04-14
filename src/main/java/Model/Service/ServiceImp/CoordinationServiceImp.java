package Model.Service.ServiceImp;

import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.CoordinationResultRepository;
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

    public List<QueriesEntity> getUncheckedQueries() {
        List<QueriesEntity> list = getAddQueries();
        list.addAll(getEditQueries());
        list.addAll(getStopQueries());

        List<QueriesEntity> result = new ArrayList<QueriesEntity>();

        for(QueriesEntity query : list){
            //adding to result list elements which doesn't have result text
            if(query.getCoordinationResult().getResultText()==null){
                result.add(query);
            }
        }
        return result;


        //repository.getCoordinationResultByResultText("");
    }

    //methods for getting specific queries
    private List<QueriesEntity> getAddQueries(){
        return repository.getQueriesByType(TypeOfQuery.ADD);
    }
    private List<QueriesEntity> getEditQueries(){
        return repository.getQueriesByType(TypeOfQuery.EDIT);
    }
    private List<QueriesEntity> getStopQueries(){
        return repository.getQueriesByType(TypeOfQuery.STOP);
    }


    public boolean checkQuery(QueriesEntity entity) {
        if(entity.getIdQuery()<=0 && entity.getCoordinationResult()!= null && entity.getMethod() != null
                && entity.getType()!=null){
            return true;
        }
        else return false;
    }

//    public String getReview(MethodicsEntity entity) {
//        List<QueriesEntity> list = repository.findAll();
//
//    }
}
