package example.addressrepo.repository;

import example.addressrepo.jpa.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
