package example.addressrepo.controller;

import example.addressrepo.config.SecurityConfig;
import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.service.ZipCodeService;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressrepo/zipcodes")
@Import(SecurityConfig.class) //Import security bypass
public class ZipCodeController {
    private final ZipCodeService zipCodeService;

    public ZipCodeController(ZipCodeService zipCodeService) {this.zipCodeService = zipCodeService;}

    @PostMapping
    public ResponseEntity<ZipCodeDto> createZipCode(@Validated @RequestBody ZipCodeDto newZipCodeRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(zipCodeService.createZipCode(newZipCodeRequest));
    }
    @PutMapping("/{requestedId}")
    public ResponseEntity<ZipCodeDto> updateZipCode(@PathVariable Integer requestedId, @Validated @RequestBody ZipCodeDto updatedZipCode){
        Optional<ZipCodeDto> zipCodeDtoOptional = zipCodeService.updateZipCode(updatedZipCode, requestedId);
        return zipCodeDtoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ZipCodeDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(zipCodeService.findAll(pageable));
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteZipCode(@PathVariable Integer code){
        zipCodeService.deleteZipCode(code);
        return ResponseEntity.noContent().build();
    }

}
