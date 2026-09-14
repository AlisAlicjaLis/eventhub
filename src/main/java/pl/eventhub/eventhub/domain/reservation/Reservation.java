package pl.eventhub.eventhub.domain.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.eventhub.eventhub.domain.customer.Customer;
import pl.eventhub.eventhub.domain.event.Event;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id",  nullable = false)
    private Event event;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @Column(name = "created_at")
    private Instant createdAt;
    @OneToMany(
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ReservationItem> items = new ArrayList<>();

    public void addItem(ReservationItem item) {
        this.items.add(item);
        item.setReservation(this);
    }
}
