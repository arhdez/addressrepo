package example.addressrepo.mapper;

import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.ZipCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper {

    ZipCodeMapper INSTANCE = Mappers.getMapper( ZipCodeMapper.class );

    //@Mapping(source = "zipCodeId", target = "zipCodeId")
    ZipCodeDto zipCodeToZipCodeDto(ZipCode zipCode);

    ZipCode zipCodeDtoToZipCode(ZipCodeDto zipCodeDto);

    /*ZipCode zipCodeDtoToZipCode(ZipCodeDto zipCodeDto);

    ZipCodeDto zipCodeToZipCodeDto(ZipCode zipCode);

    void update(@MappingTarget ZipCode existent, ZipCodeDto updatedZipCodeDto);*/
}
