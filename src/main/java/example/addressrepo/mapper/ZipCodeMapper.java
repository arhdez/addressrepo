package example.addressrepo.mapper;

import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.ZipCode;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper {

    ZipCode zipCodeDtoToZipCode(ZipCodeDto zipCodeDto);

    ZipCodeDto zipCodeToZipCodeDto(ZipCode zipCode);

    void update(@MappingTarget ZipCode existent, ZipCodeDto updatedZipCodeDto);
}
