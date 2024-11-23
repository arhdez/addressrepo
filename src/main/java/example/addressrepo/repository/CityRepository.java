package example.addressrepo.repository;

import example.addressrepo.jpa.City;
import example.addressrepo.model.StateAbbreviation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends CrudRepository<City, Integer> {
    boolean existsByCityNameAndStateAbbreviation(@Param("cityName") String cityName, @Param("stateAbbreviation") StateAbbreviation stateAbbreviation);

    boolean existsById(@Param("cityId") Integer id);
}
