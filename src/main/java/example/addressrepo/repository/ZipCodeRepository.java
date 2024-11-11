package example.addressrepo.repository;

import example.addressrepo.jpa.ZipCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.repository.CrudRepository;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
    boolean existsByCode(@Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "Invalid zip code format") @NotBlank @NotNull String code);
}
