package example.addressrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import example.addressrepo.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {

    @JsonProperty("address_id")
    private UUID addressId;

    @NotBlank(groups = CreateGroup.class)
    @NotNull(groups = CreateGroup.class)
    private String street;

    @JsonProperty("city_id")
    @NotNull(groups = CreateGroup.class)
    private Integer cityId;

    @JsonProperty("zip_code_id")
    @NotNull(groups = CreateGroup.class)
    private Integer zipCodeId;

}
