package example.addressrepo.service;

import example.addressrepo.dto.CityDto;
import example.addressrepo.jpa.City;
import example.addressrepo.mapper.CityMapper;
import example.addressrepo.model.StateAbbreviation;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.validation.DoesNotExistsException;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityDto createCity(CityDto cityDto) {
        cityExists(cityDto);
        return cityMapper.cityToCityDto(cityRepository.save(cityMapper.cityDtoToCity(cityDto)));
    }

    public List<CityDto> findAll(Pageable pageable){
        PageRequest pageRequest= PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "cityName")));
        return cityRepository.findAll(pageRequest).stream().map(cityMapper::cityToCityDto).collect(Collectors.toList());
    }

    public Optional<CityDto> updateCity(CityDto cityToUpdateDto, Integer requestedId){
        Optional<City> existentCityOptional = cityRepository.findById(requestedId);

        if (existentCityOptional.isPresent()){
            City existingCity = existentCityOptional.get();
            cityMapper.update(existingCity, cityToUpdateDto);
            cityExists(existingCity);
            return Optional.of(cityMapper.cityToCityDto(cityRepository.save(existingCity)));
        }
        return Optional.empty();
    }

    public void deleteCity(Integer id){
        if (!cityRepository.existsById(id)){
            throw new DoesNotExistsException("City with id: "+ id + " not found");
        }
        cityRepository.deleteById(id);
    }

    private void cityExists(City city){
        cityExists(city.getCityName(), city.getStateAbbreviation());
    }
    private void cityExists(CityDto cityDto){
        cityExists(cityDto.getCityName(), cityDto.getStateAbbreviation());
    }
    private void cityExists(String cityName, StateAbbreviation stateAbbreviation) {
        if (cityRepository.existsByCityNameAndStateAbbreviation(cityName, stateAbbreviation)) {
            throw new DuplicateException("City already exists: " + cityName + " in the state " +
                    stateAbbreviation.getStateDescription());
        }
    }

}
