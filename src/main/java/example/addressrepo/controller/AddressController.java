package example.addressrepo.controller;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.service.AddressService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressrepo/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService){this.addressService = addressService;}

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@Validated @RequestBody AddressDto newAddressRequested){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(newAddressRequested));
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(addressService.findAll(pageable));
    }
}
