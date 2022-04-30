package labs.week2.task1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private BigDecimal price;
    private final String publisher;
    private final LocalDate publishedYear;

    public Book(String title, String author, String publisher, LocalDate publishedYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(publishedYear.getYear(), book.publishedYear.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishedYear.getYear());
    }
}