package example.addressrepo.service;

import example.addressrepo.dto.CityDto;
import example.addressrepo.mapper.CityMapper;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityDto createCity(CityDto cityDto) {
        if (cityRepository.existsByCityNameAndStateAbbreviation(cityDto.getCityName(), cityDto.getStateAbbreviation())) {
            throw new DuplicateException("City already exists: " + cityDto.getCityName() + " in the state " +
                    cityDto.getStateAbbreviation().getStateDescription());
        }
        return cityMapper.cityToCityDto(cityRepository.save(cityMapper.cityDtoToCity(cityDto)));
    }

    public List<CityDto> findAll(Pageable pageable){
        PageRequest pageRequest= PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "cityName")));
        return cityRepository.findAll(pageRequest).stream().map(cityMapper::cityToCityDto).collect(Collectors.toList());
    }
}
