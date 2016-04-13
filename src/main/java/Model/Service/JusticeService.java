package Model.Service;

import Model.Entity.PackagesEntity;

/**
 * Created by talizorah on 16.13.4.
 */
public interface JusticeService {
    void getUncheckedPackages();
    void getRegisterQueries();
    void checkPackager(PackagesEntity entity);
    void addToRegister(PackagesEntity entity);
}
