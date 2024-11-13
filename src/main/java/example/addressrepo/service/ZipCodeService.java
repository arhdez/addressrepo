package example.addressrepo.service;

import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.jpa.ZipCode;
import example.addressrepo.mapper.ZipCodeMapper;
import example.addressrepo.repository.ZipCodeRepository;
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
public class ZipCodeService {

    private final ZipCodeRepository zipCodeRepository;
    private final ZipCodeMapper zipCodeMapper;

    public ZipCodeDto createZipCode(ZipCodeDto zipCodeDto) {
        if(zipCodeRepository.existsByCode(zipCodeMapper.zipCodeDtoToZipCode(zipCodeDto).getCode())){
            throw new DuplicateException("Zip Code already exists: " + zipCodeDto.getCode());
        }
        return zipCodeMapper.zipCodeToZipCodeDto(zipCodeRepository.save(zipCodeMapper.zipCodeDtoToZipCode(zipCodeDto)));
    }

    public Optional<ZipCodeDto> updateZipCode(ZipCodeDto zipCodeDto, Long requestedId){
        Optional<ZipCode> existingZipCodeOptional = zipCodeRepository.findById(requestedId);
        if(zipCodeRepository.existsByCode(zipCodeDto.getCode())){
            throw new DuplicateException("Zip Code already exists: " + zipCodeDto.getCode());
        }
        if(existingZipCodeOptional.isPresent()){
            ZipCode existingZipCode = existingZipCodeOptional.get();
            zipCodeMapper.update(existingZipCode, zipCodeDto);
            return Optional.of(zipCodeMapper.zipCodeToZipCodeDto(zipCodeRepository.save(existingZipCode)));
        }
        return Optional.empty();
    }

    public List<ZipCodeDto> findAll(Pageable pageable){
        PageRequest pageRequest =
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "code")));
        return zipCodeRepository.findAll(pageRequest).stream().map(zipCodeMapper::zipCodeToZipCodeDto).collect(Collectors.toList());
    }
    public void deleteZipCode(String code){
        if (zipCodeRepository.findByCode(code).isPresent()) {
            Long requestedId = zipCodeRepository.findByCode(code).get().getZipCodeId();
            zipCodeRepository.deleteById(requestedId);
        }
        else{ throw new DoesNotExistsException("Zip Code it does not exists: " + code); }
    }
}
