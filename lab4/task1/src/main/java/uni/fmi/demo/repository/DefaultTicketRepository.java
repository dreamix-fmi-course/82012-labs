package uni.fmi.demo.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.demo.model.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// !!! singleton is the default scope, the db is singleton

@Repository
public class DefaultTicketRepository implements TicketRepository {
    private static long counter = 0;
    private final Map<Long, Ticket> ticketMap = new HashMap<>();

    @Override
    public void createTicket(Ticket u) {
        validateTicket(u);
        ticketMap.put(counter++, u);
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
        ticketMap.put(counter++, ticket);
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
