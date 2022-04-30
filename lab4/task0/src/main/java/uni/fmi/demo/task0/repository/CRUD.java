package uni.fmi.demo.task0.repository;

import uni.fmi.demo.task0.model.Book;

import java.util.List;

public interface CRUD {

    void add(Book book);

    Book update(Book book);

    void remove(String isbn);

    Book getByKey(String isbn);

    List<Book> getAll();

    void clear();
}