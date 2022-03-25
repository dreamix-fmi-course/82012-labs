package uni.fmi.demo.repository;

import uni.fmi.demo.model.Ticket;

import java.util.List;

public interface TicketRepository {
    /**
     * Create ticket
     */
    void createTicket(Ticket u);

    /**
     * Remove ticket
     */
    void removeTicket(Long id);

    /**
     * Find ticket by Id
     */
    Ticket findById(Long id);

    /**
     * Update ticket information
     */
    void updateTicketById(Ticket ticket);

    List<Ticket> getAllTickets();
}