package example.addressrepo.mapper;

import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.ZipCode;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper {

    ZipCode zipCodeDtoToZipCode(ZipCodeDto zipCodeDto);

    ZipCodeDto zipCodeToZipCodeDto(ZipCode zipCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget ZipCode existent, ZipCodeDto updatedZipCodeDto);
}
