package uni.fmi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.fmi.demo.model.Event;
import uni.fmi.demo.model.Ticket;
import uni.fmi.demo.model.User;
import uni.fmi.demo.repository.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultTicketService implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public DefaultTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void createTicket(Ticket u) {
        ticketRepository.createTicket(u);
    }

    @Override
    public void removeTicket(Long id) {
        ticketRepository.removeTicket(id);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void updateTicketById(Long id) {
        ticketRepository.updateTicketById(findById(id));
    }

    @Override
    public List<Ticket> findAllTicketsByUser(User user) {
        return ticketRepository.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getUser().equals(user))
                .toList();
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event event) {
        return ticketRepository.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .toList();
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to) {
        return ticketRepository.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getEvent().getDate().toLocalDate().isAfter(from) &&
                        ticket.getEvent().getDate().toLocalDate().isBefore(to))
                .distinct()
                .map(Ticket::getEvent)
                .toList();
    }
}
