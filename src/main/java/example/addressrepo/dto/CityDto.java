package example.addressrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import example.addressrepo.model.StateAbbreviation;
import example.addressrepo.validation.CreateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CityDto {

    private Integer cityId;

    @JsonProperty("city_name")
    @NotBlank(groups = CreateGroup.class)
    @NotNull(groups = CreateGroup.class)
    private String cityName;

    //@Pattern(regexp = "^[A-Z]{2}$", message = "State abbreviation must be exactly 2 uppercase letters")
    @JsonProperty("state_abbreviation")
    @NotBlank(groups = CreateGroup.class)
    @NotNull(groups = CreateGroup.class)
    private StateAbbreviation stateAbbreviation;
}
