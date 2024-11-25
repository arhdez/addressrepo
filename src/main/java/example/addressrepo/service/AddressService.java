package example.addressrepo.service;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.jpa.Address;
import example.addressrepo.mapper.AddressMapper;
import example.addressrepo.repository.AddressRepository;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.repository.ZipCodeRepository;
import example.addressrepo.validation.DoesNotExistsException;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDto createAddress(AddressDto addressDto) {
        validateAddress(addressDto);
        return addressMapper.addresstoAddressDto(addressRepository.save(addressMapper.addressDtoToAddress(addressDto)));
    }

    public Optional<AddressDto> updateAddress(AddressDto addressToUpdateDto, UUID requestedId) {
        Optional<Address> existentAddressOptional = addressRepository.findById(requestedId);

        if (existentAddressOptional.isPresent()) {
            Address existentAddress = existentAddressOptional.get();
            addressMapper.update(existentAddress, addressToUpdateDto);
            validateAddress(existentAddress);
            return Optional.of(addressMapper.addresstoAddressDto(addressRepository.save(existentAddress)));
        }
        return Optional.empty();
    }

    public List<AddressDto> findAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "street")));
        return addressRepository.findAll(pageRequest).stream().map(addressMapper::addresstoAddressDto).collect(Collectors.toList());
    }

    public void deleteAddress(UUID addressId) {
        if (!addressRepository.existsById(addressId)) {
            throw new DoesNotExistsException("Address with Id: " + addressId + " does not exist");
        }
        addressRepository.deleteById(addressId);
    }

    private void validateAddress(AddressDto addressDto) {
        validateAddress(addressDto.getStreet(), addressDto.getCityId(), addressDto.getZipCodeId());
    }

    private void validateAddress(Address address) {
        validateAddress(address.getStreet(), address.getCityId(), address.getZipCodeId());
    }

    private void validateAddress(String street, Integer city, Integer zipCode) {
        validateZipCode(zipCode);
        validateCity(city);
        validateAddressAvailability(street, city, zipCode);
    }

    private void validateZipCode(Integer zipCodeId) {
        if (zipCodeId != null && !zipCodeRepository.existsById(zipCodeId)) {
            throw new DoesNotExistsException("Zip Code: " + zipCodeId + " does not exist");
        }
    }

    private void validateCity(Integer cityId) {
        if (cityId != null && !cityRepository.existsById(cityId)) {
            throw new DoesNotExistsException("City with Id: " + cityId + " does not exist");
        }
    }

    private void validateAddressAvailability(String street, Integer cityId, Integer zipCodeId) {
        if (addressRepository.existsByStreetAndCityIdAndZipCodeId(street, cityId, zipCodeId)) {
            throw new DuplicateException("The address already exists");
        }
    }
}
