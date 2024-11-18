package example.addressrepo.controller;

import example.addressrepo.config.SecurityConfig;
import example.addressrepo.dto.CityDto;
import example.addressrepo.service.CityService;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressrepo/cities")
@Import(SecurityConfig.class)
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {this.cityService = cityService;}

    @PostMapping
    public ResponseEntity<CityDto> createCity(@Validated @RequestBody CityDto newCityRequested){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(newCityRequested));
    }
}
