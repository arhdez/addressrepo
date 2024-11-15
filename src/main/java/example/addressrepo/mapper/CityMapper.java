package example.addressrepo.mapper;

import example.addressrepo.dto.CityDto;
import example.addressrepo.jpa.City;
import org.mapstruct.*;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {

    CityDto cityToCityDto(City city);

    City cityDtoToCity(CityDto cityDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget City existent, CityDto updatedCityDto);
}
