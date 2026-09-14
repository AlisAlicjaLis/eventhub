package pl.eventhub.eventhub.domain.event;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Money {

    @Column(name = "price_amount")
    private BigDecimal amount;
    @Column(name = "price_currency")
    private String currency;
}
