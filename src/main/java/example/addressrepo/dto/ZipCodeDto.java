package example.addressrepo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ZipCodeDto {

    private long zipCodeId;

    @JsonProperty("code")
    @Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "Invalid zip code format")
    @NotBlank
    @NotNull
    private String code;

   /* public long getZipCodeId() {
        return zipCodeId;
    }

    public void setZipCodeId(long zipCodeId) {
        this.zipCodeId = zipCodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/
}
