package example.addressrepo.controller;

import example.addressrepo.config.SecurityConfig;
import example.addressrepo.dto.ZipCodeDto;
import example.addressrepo.service.ZipCodeService;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressrepos")
@Import(SecurityConfig.class) //Import security bypass
public class ZipCodeController {
    private final ZipCodeService zipCodeService;

    public ZipCodeController(ZipCodeService zipCodeService) {this.zipCodeService = zipCodeService;}

    @PostMapping
    public ResponseEntity<ZipCodeDto> createZipCode(@Validated @RequestBody ZipCodeDto newZipCodeRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(zipCodeService.createZipCode(newZipCodeRequest));
    }
}
