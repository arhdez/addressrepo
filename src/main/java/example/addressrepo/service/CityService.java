package example.addressrepo.service;

import example.addressrepo.dto.CityDto;
import example.addressrepo.mapper.CityMapper;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    /*public CityDto getCityById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        return toDto(city);
    }*/
    public CityDto createCity(CityDto cityDto) {
        if (cityRepository.existsByCityNameAndStateAbbreviation(cityDto.getCityName(), cityDto.getStateAbbreviation().name())) {
            throw new DuplicateException("City already exists: " + cityDto.getCityName() + " in the state " +
                    cityDto.getStateAbbreviation().getStateDescription());
        }
        return cityMapper.cityToCityDto(cityRepository.save(cityMapper.cityDtoToCity(cityDto)));
    }
}
