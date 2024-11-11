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
}
