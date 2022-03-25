package labs.week2.task1.service;

import labs.week2.task1.model.Book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {
    private final Set<Book> books;

    public BookStore() {
        this.books = new HashSet<>();
    }

    @Override
    public boolean add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        return books.add(book);
    }

    @Override
    public void remove(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        books.remove(book);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or blank");
        }

        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        if (from == null) {
            throw new IllegalArgumentException("From date cannot be null");
        }

        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .toList();
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        if (from == null) {
            throw new IllegalArgumentException("From/To date cannot be null");
        }

        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from)
                        && book.getPublishedYear().isBefore(to))
                .toList();
    }

    @Override
    public void clear() {
        this.books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        if (bookPredicate == null) {
            throw new IllegalArgumentException("Predicate cannot be null");
        }

        return books.stream()
                .filter(bookPredicate)
                .toList();
    }

    public int getSize() {
        return books.size();
    }
}
