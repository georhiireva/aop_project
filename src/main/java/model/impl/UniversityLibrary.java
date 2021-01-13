package model.impl;

import model.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Мы берем книгу в библиотеке университета");
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу в блиблиотеку университета");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал в библиотеке университета");
    }

    public void getBook(String bookName) {
        System.out.println("Мы берем книгу в библиотеке университета: " + bookName);
    }

    public void getBook(Book book) {
        System.out.println("Мы берем книгу в библиотеке университета: " + book.getName());
    }
}
