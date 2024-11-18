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
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Enumerated(EnumType.STRING) // Ensure this maps to the enum as a string in the DB
    @Column(name = "state_abbreviation", nullable = false)
    private StateAbbreviation stateAbbreviation;
}
