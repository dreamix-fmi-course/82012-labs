package uni.fmi.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Ticket {
    private Long ticketId;
    private BigDecimal price;
    private int row;
    private int seat;
    private User user;
    private Event event;
}
