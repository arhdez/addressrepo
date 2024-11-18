package example.addressrepo.repository;

import example.addressrepo.jpa.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID>, PagingAndSortingRepository<Address, UUID> {
    boolean existsByStreet(String street);
    boolean existsByCityId(Integer cityId);
    boolean existsByZipCodeId(Integer zipCodeId);
}
