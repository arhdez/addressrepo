package example.addressrepo.repository;

import example.addressrepo.jpa.ZipCode;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.repository.CrudRepository;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
    boolean existsByCode(String code);
}
