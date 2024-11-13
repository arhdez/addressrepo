package example.addressrepo.repository;

import example.addressrepo.jpa.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {
}
