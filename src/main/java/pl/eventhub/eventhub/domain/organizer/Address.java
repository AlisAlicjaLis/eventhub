package pl.eventhub.eventhub.domain.organizer;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;
}
