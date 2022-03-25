package uni.fmi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.demo.model.Event;
import uni.fmi.demo.model.Ticket;
import uni.fmi.demo.model.User;
import uni.fmi.demo.repository.TicketRepository;
import uni.fmi.demo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void createUser(User u) {
        userRepository.addUser(u);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUserInformation(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<Event> getAllVisitedEvent() {
        return ticketRepository.getAllTickets()
                .stream()
                .map(Ticket::getEvent)
                .distinct()
                .toList();
    }

    @Override
    public List<Event> getAllVisitedEventsInPastMonth() {
        return ticketRepository.getAllTickets()
                .stream()
                .map(Ticket::getEvent)
                .filter(event -> event.getDate().isAfter(LocalDateTime.now().minusMonths(1)) &&
                        event.getDate().isBefore(LocalDateTime.now()))
                .distinct()
                .toList();
    }
}
