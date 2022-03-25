package uni.fmi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uni.fmi.demo.service.EventService;
import uni.fmi.demo.service.TicketService;
import uni.fmi.demo.service.UserService;

@SpringBootApplication
public class Task1Application implements CommandLineRunner {

	@Autowired
	private EventService eventService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("zdrr");
		eventService.removeEvent(12L);
		ticketService.findById(12L);
		ticketService.removeTicket(12L);

		try {
			ticketService.updateTicketById(12L);
		} catch(IllegalArgumentException e) {
			System.out.println("No such ticket");
		}

		userService.deleteUser(12L);
		userService.findById(12L);

	}
}
