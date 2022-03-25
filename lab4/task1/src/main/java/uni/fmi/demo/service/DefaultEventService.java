package uni.fmi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.demo.model.Event;
import uni.fmi.demo.repository.EventRepository;

@Service
public class DefaultEventService implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Event u) {
        eventRepository.createEvent(u);
    }

    @Override
    public void removeEvent(Long id) {
        eventRepository.removeEvent(id);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.updateEvent(event);
    }
}
