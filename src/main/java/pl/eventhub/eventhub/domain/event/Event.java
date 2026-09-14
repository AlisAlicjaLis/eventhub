package pl.eventhub.eventhub.domain.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.eventhub.eventhub.domain.organizer.Organizer;

import java.time.Instant;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Instant startsAt;
    private Instant endsAt;
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;
}
