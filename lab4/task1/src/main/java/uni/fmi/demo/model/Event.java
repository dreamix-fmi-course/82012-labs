package uni.fmi.demo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Event {
    private Long eventId;
    private String name;
    private LocalDateTime date;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId)
                && Objects.equals(name, event.name)
                && Objects.equals(date, event.date)
                && Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, name, date, description);
    }
}