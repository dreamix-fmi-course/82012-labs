package uni.fmi.demo.task0.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishedYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(publishedYear, book.publishedYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, author, price, publisher, publishedYear);
    }
}