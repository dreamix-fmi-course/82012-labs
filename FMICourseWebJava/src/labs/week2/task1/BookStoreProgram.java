package labs.week2.task1;

import labs.week2.task1.model.Book;
import labs.week2.task1.service.BookStore;

import java.time.LocalDate;

public class BookStoreProgram {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.add(new Book("book1", "pesho", "ciela", LocalDate.of(2020, 9,9)));
        store.add(new Book("book1", "pesho", "text", LocalDate.of(2020, 11,24)));
        System.out.println(store.getSize()); // 1


    }
}
