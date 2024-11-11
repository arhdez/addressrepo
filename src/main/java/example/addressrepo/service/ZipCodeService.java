package example.addressrepo.service;

import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.ZipCode;
import example.addressrepo.mapper.ZipCodeMapper;
import example.addressrepo.repository.ZipCodeRepository;
import example.addressrepo.validation.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZipCodeService {

    private final ZipCodeRepository zipCodeRepository;
    private final ZipCodeMapper zipCodeMapper;

    public ZipCodeDto createZipCode(ZipCodeDto zipCodeDto) {
        if(zipCodeRepository.existsByCode(zipCodeDto.getCode())){
            throw new DuplicateException("Zip Code already exists: " + zipCodeDto.getCode());
        }

        return zipCodeMapper.zipCodeToZipCodeDto(zipCodeRepository.save(zipCodeMapper.zipCodeDtoToZipCode(zipCodeDto)));
    }
}
