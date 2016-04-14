package Model.Repository;

import Model.Entity.PackagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xoll on 12.04.16.
 */
public interface PackagesRepository extends JpaRepository<PackagesEntity, Integer> {
    List<PackagesEntity> getPackgesEntityByReview(String review);
}
