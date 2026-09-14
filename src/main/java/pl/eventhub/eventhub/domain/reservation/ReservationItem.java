package pl.eventhub.eventhub.domain.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.eventhub.eventhub.domain.event.Money;
import pl.eventhub.eventhub.domain.event.TicketType;

@Entity
@Table(name = "reservation_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;
    private Integer quantity;
    @Embedded
    @AttributeOverrides({@AttributeOverride(
            name = "amount",
            column = @Column(name = "unit_price_amount")
    ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "unit_price_currency")
            )
    })
    private Money price;

    protected void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
