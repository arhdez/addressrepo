package example.addressrepo.jpa;

import example.addressrepo.model.StateAbbreviation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column
    private String cityName;

    @Enumerated(EnumType.STRING)
    @Column(name="state_abbreviation", length = 2, nullable = false)
    private StateAbbreviation stateAbbreviation;
}
