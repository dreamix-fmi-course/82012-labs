package uni.fmi.demo.repository;

import uni.fmi.demo.model.Event;

import java.util.List;

public interface EventRepository {
    /***
     * Create event
     * @param event
     */
    void createEvent(Event event);

    /**
     * Remove event
     * @param id
     */
    void removeEvent(Long id);

    /**
     * Find event by id
     * @param id of the event
     * @return
     */
    Event findById(Long id);


    /**
     * Update event information
     * @param event
     */
    void updateEvent(Event event);

    List<Event> getAllEvents();
}
