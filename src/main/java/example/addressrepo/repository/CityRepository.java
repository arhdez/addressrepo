package example.addressrepo.repository;

import example.addressrepo.jpa.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends CrudRepository<City, Integer> {
    //boolean existsByCityNameAndStateAbbreviation(String cityName, StateAbbreviation stateAbbreviation);
    @Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM city c WHERE c.city_name = :cityName AND c.state_abbreviation = CAST(:stateAbbreviation AS state_abbreviation)",
            nativeQuery = true)
    boolean existsByCityNameAndStateAbbreviation(@Param("cityName") String cityName, @Param("stateAbbreviation") String stateAbbreviation);
    boolean existsById(@Param("cityId") Integer id);
}
