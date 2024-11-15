package example.addressrepo.service;

import example.addressrepo.dto.CityDto;
import example.addressrepo.mapper.CityMapper;
import example.addressrepo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityDto createCity(CityDto cityDto) {
        return cityMapper.cityToCityDto(cityRepository.save(cityMapper.cityDtoToCity(cityDto)));
    }
}
