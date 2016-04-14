package Model.Service;

import Model.Entity.PackagesEntity;
import Model.Entity.QueriesEntity;

import java.util.List;

/**
 * Created by talizorah on 16.13.4.
 */
public interface JusticeService {
    List<PackagesEntity> getUncheckedPackages();
    //List<QueriesEntity> getRegisterQueries();
    //boolean checkPackage(PackagesEntity entity);
    boolean addToRegister(PackagesEntity entity);
}
