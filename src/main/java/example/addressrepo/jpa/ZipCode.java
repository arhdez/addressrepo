package example.addressrepo.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "zipcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zipcode_id;

    @Column
    private String code;

}
