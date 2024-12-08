package example.addressrepo.service;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.dto.AddressKafkaDto;
import example.addressrepo.dto.CityDto;
import example.addressrepo.jpa.ZipCode;
import example.addressrepo.mapper.CityMapper;
import example.addressrepo.repository.CityRepository;
import example.addressrepo.repository.ZipCodeRepository;
import example.addressrepo.validation.DoesNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, AddressKafkaDto> kafkaTemplate;
    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;


    public void sendMessage(AddressDto addressDto){
        Message<AddressKafkaDto> message = MessageBuilder
                .withPayload(createAddressKafkaDto(addressDto))
                .setHeader(KafkaHeaders.TOPIC, "address-topic")
                .build();
        kafkaTemplate.send(message);
    }
    private AddressKafkaDto createAddressKafkaDto(AddressDto addressDto) {
        AddressKafkaDto addressKafkaDto = new AddressKafkaDto();
        // Fetch city and state
        CityDto city = getCityDto(addressDto.getCityId());
        addressKafkaDto.setCity(city.getCityName());
        addressKafkaDto.setState(city.getStateAbbreviation().getStateDescription());
        // Fetch zip code
        String zipCode = getZipCode(addressDto.getZipCodeId());
        addressKafkaDto.setZipCode(zipCode);
        // Set other properties
        addressKafkaDto.setAddressId(addressDto.getAddressId());
        addressKafkaDto.setStreet(addressDto.getStreet());
        return addressKafkaDto;
    }

    private String getZipCode(Integer zipCodeId) {
        return zipCodeRepository.findById(zipCodeId)
                .map(ZipCode::getCode)
                .orElseThrow(() -> new DoesNotExistsException("Zip code not found for ID: " + zipCodeId));
    }

    private CityDto getCityDto(Integer cityId) {
        return cityMapper.cityToCityDto(cityRepository.findById(cityId)
                .orElseThrow(() -> new DoesNotExistsException("City not found for ID: " + cityId)));
    }
}
