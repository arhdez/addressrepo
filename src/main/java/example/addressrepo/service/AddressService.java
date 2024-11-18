package example.addressrepo.service;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.jpa.ZipCode;
import example.addressrepo.mapper.AddressMapper;
import example.addressrepo.repository.AddressRepository;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.repository.ZipCodeRepository;
import example.addressrepo.validation.DoesNotExistsException;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public boolean validZipCode(Integer zipCodeId) {
        if(zipCodeRepository.findById(zipCodeId).isPresent()) {
            return true;
        } else throw new DoesNotExistsException("Zip Code: " + zipCodeId + " does not exist");
    }
    public boolean validCity(Integer cityId){
        if(cityRepository.existsById(cityId)){
            return true;
        } else throw new DoesNotExistsException("City with Id: " + cityId + " does not exist");
    }
    public boolean addressAvailable(AddressDto addressDto) {
        boolean available = addressRepository.existsByStreet(addressDto.getStreet());
        boolean cityId = addressRepository.existsByCityId(addressDto.getCityId());
        boolean zipCodeId = addressRepository.existsByZipCodeId(addressDto.getZipCodeId());
        if(available && cityId && zipCodeId){
            throw new DuplicateException("The address already exists");
        }
        return true;
    }
    public AddressDto createAddress(AddressDto addressDto){
      if(validZipCode(addressDto.getZipCodeId())
              && validCity(addressDto.getCityId())
              && addressAvailable(addressDto))
        return addressMapper.addresstoAddressDto(addressRepository.save(addressMapper.addressDtoToAddress(addressDto)));
      else throw new RuntimeException("Invalid address");
    }

    public List<AddressDto> findAll(Pageable pageable){
        PageRequest pageRequest =
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "street")));
        return addressRepository.findAll(pageRequest).stream().map(addressMapper::addresstoAddressDto).collect(Collectors.toList());
    }
}
