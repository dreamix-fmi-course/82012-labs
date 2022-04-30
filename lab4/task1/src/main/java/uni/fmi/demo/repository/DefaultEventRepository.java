package uni.fmi.demo.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.demo.model.Event;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultEventRepository implements EventRepository {
    private final Map<Long, Event> eventMap = new ConcurrentHashMap<>();

    @Override
    public void createEvent(Event event) {
        validateEvent(event);
        eventMap.put(event.getEventId(), event);
    }

    @Override
    public void removeEvent(Long id) {
        validateId(id);
        eventMap.remove(id);
    }

    @Override
    public Event findById(Long id) {
        validateId(id);
        return eventMap.get(id);
    }

    @Override
    public void updateEvent(Event event) {
        validateEvent(event);
        removeEvent(event.getEventId());
        eventMap.put(event.getEventId(), event);
    }

    @Override
    public List<Event> getAllEvents() {
        return Collections.unmodifiableList(eventMap.values().stream().toList());
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    private void validateEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
    }
}
