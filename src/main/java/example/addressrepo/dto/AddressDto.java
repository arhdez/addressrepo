package example.addressrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {

    @JsonProperty("address_id")
    private UUID addressId;

    private String street;

    @JsonProperty("city_id")
    private Integer cityId;

    @JsonProperty("zip_code_id")
    private Integer zipCodeId;

}
