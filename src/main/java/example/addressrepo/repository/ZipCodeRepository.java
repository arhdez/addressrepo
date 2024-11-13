package example.addressrepo.repository;

import example.addressrepo.jpa.ZipCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface ZipCodeRepository extends CrudRepository<ZipCode, Long>, PagingAndSortingRepository<ZipCode, Long> {
    boolean existsByCode(String code);

     Optional<ZipCode> findByCode(String code);
}
