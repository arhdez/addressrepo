package example.addressrepo.controller;

import example.addressrepo.dto.AddressDto;
import example.addressrepo.service.AddressService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PutMapping("/{requestedId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable UUID requestedId, @Validated @RequestBody AddressDto updatedAddress){
        Optional<AddressDto> addressDtoOptional = addressService.updateAddress(updatedAddress, requestedId);
        return addressDtoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{requestedId}")
    public ResponseEntity<AddressDto> patchAddress(@PathVariable UUID requestedId, @Validated @RequestBody AddressDto updatedAddress){
        Optional<AddressDto> address = addressService.updateAddressByFields(requestedId, updatedAddress);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{requestedId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID requestedId){
        addressService.deleteAddress(requestedId);
        return ResponseEntity.noContent().build();
    }
}