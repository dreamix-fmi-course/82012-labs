package uni.fmi.demo.service;

import uni.fmi.demo.model.Event;

public interface EventService {
    void createEvent(Event u);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);
}
