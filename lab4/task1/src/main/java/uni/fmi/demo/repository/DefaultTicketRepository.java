package uni.fmi.demo.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.demo.model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// !!! singleton is the default scope, the db is singleton

@Repository
public class DefaultTicketRepository implements TicketRepository {
    private final Map<Long, Ticket> ticketMap = new ConcurrentHashMap<>();

    @Override
    public void createTicket(Ticket u) {
        validateTicket(u);
        ticketMap.put(u.getTicketId(), u);
    }

    @Override
    public void removeTicket(Long id) {
        validateId(id);
        ticketMap.remove(id);
    }

    @Override
    public Ticket findById(Long id) {
        validateId(id);
        return ticketMap.get(id);
    }

    @Override
    public void updateTicketById(Ticket ticket) {
        validateTicket(ticket);
        removeTicket(ticket.getTicketId());
        ticketMap.put(ticket.getTicketId(), ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketMap.values().stream().toList();
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    private void validateTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
    }
}
