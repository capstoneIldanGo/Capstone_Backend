package jungsaesidae.capstone.repository;

import jungsaesidae.capstone.domain.Location;
import jungsaesidae.capstone.repository.custom.LocationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom {

    @Query(value = "select distinct loc.city from dev.location loc", nativeQuery = true)
    public List<String> findAllCity();

    @Query(value = "select loc.state from dev.location loc where loc.city = :city", nativeQuery = true)
    public List<String> findAllStateByCity(@Param(value = "city") String city);
}
