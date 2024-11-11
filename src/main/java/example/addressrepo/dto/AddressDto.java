package example.addressrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressDto {

    @JsonProperty("address_id")
    private Long addressId;

    private String address;

    @JsonProperty("city_id")
    private String cityId;

    @JsonProperty("state_id")
    private String stateId;

}
