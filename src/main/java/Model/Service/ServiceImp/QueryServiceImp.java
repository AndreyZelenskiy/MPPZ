package Model.Service.ServiceImp;

import Model.Entity.CoordinationResultsEntity;
import Model.Entity.MethodicsEntity;
import Model.Entity.QueriesEntity;
import Model.Entity.TypeOfQuery;
import Model.Repository.QueriesRepository;
import Model.Service.QueryService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by talizorah on 16.14.4.
 */
@Service
public class QueryServiceImp implements QueryService {

    @Inject
    QueriesRepository queriesRepository;

    public void createQuery(MethodicsEntity entity, TypeOfQuery typeOfQuery) {
        QueriesEntity queriesEntity = new QueriesEntity();
        queriesEntity.setType(typeOfQuery);
        queriesEntity.setMethod(entity);
        queriesEntity.setCoordinationResult(null);
        queriesRepository.save(queriesEntity);
    }
}
