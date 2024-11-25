package example.addressrepo.controller;

import example.addressrepo.config.SecurityConfig;
import example.addressrepo.dto.CityDto;
import example.addressrepo.service.CityService;
import example.addressrepo.validation.CreateGroup;
import example.addressrepo.validation.PatchGroup;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressrepo/cities")
@Import(SecurityConfig.class)
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {this.cityService = cityService;}

    @PostMapping
    public ResponseEntity<CityDto> createCity(@Validated(CreateGroup.class) @RequestBody CityDto newCityRequested){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(newCityRequested));
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(cityService.findAll(pageable));
    }

    @PutMapping("/{requestedId}")
    public ResponseEntity<CityDto> updateCity(@PathVariable Integer requestedId, @Validated(CreateGroup.class) @RequestBody CityDto updatedCity){
        Optional<CityDto> updatedCityOptional = cityService.updateCity(updatedCity ,requestedId);
        return updatedCityOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{requestedId}")
    public ResponseEntity<CityDto> patchCity(@PathVariable Integer requestedId, @Validated(PatchGroup.class) @RequestBody CityDto updatedCity){
        Optional<CityDto> updatedCityOptional = cityService.updateCity(updatedCity, requestedId);
        return updatedCityOptional.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id){
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
