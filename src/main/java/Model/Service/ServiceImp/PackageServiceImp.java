package Model.Service.ServiceImp;

import Model.Entity.*;
import Model.Repository.PackagesRepository;
import Model.Service.PackageService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.SecondaryTable;

/**
 * Created by talizorah on 16.14.4.
 */
@Service
public class PackageServiceImp implements PackageService {
    @Inject
    PackagesRepository packagesRepository;


    public void createPackage(MethodicsEntity methodicsEntity,
                              CoordinationResultsEntity coordinationResultsEntity,
                              TypeOfQuery queryType,
                              String review) {
        PackagesEntity packagesEntity = new PackagesEntity();
        packagesEntity.setReview(review);
        packagesEntity.setJucticeResult(null);
        packagesEntity.setMethod(methodicsEntity);
        packagesEntity.setCoordinationResult(coordinationResultsEntity);
        packagesEntity.setType(queryType);
        packagesRepository.save(packagesEntity);
    }
}
