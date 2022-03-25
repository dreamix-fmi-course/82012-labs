package uni.fmi.demo.task0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uni.fmi.demo.task0.model.Book;
import uni.fmi.demo.task0.service.BookStore;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    BookStore bookStore;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("helloooo");
        bookStore.clear();
    }
}
