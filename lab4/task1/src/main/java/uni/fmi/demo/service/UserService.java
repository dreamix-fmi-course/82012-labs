package uni.fmi.demo.service;

import uni.fmi.demo.model.Event;
import uni.fmi.demo.model.User;

import java.util.List;

public interface UserService {
    void createUser(User u);

    void deleteUser(Long id);

    User findById(Long id);

    void updateUserInformation(User user);

    /**
     * Return all visited events
     */
    List<Event> getAllVisitedEvent();

    /**
     * Return all visited events for the past month
     */
    List<Event> getAllVisitedEventsInPastMonth();
}
