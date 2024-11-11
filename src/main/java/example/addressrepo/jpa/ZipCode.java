package example.addressrepo.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Entity
@Table(name = "zipcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zipCodeId;

    @Column
    private String code;

    /*public Long getZipCodeId() {
        return zipCodeId;
    }

    public void setZipCodeId(Long zipCodeId) {
        this.zipCodeId = zipCodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/
}
