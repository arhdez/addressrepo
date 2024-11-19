package example.addressrepo.mapper;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.Address;
import example.addressrepo.jpa.ZipCode;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    Address addressDtoToAddress(AddressDto addressDto);

    AddressDto addresstoAddressDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Address existent, AddressDto updatedAddressDto);
}
