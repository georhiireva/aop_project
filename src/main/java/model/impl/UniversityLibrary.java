package model.impl;

import model.AbstractLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {

    @Override
    public void addBook(Book book) {
        super.addBook(book);
    }

    @Override
    public Book getBook(String name) {
        return super.getBook(name);
    }

    @Override
    public void returnBook(Book book) {
        super.returnBook(book);
    }

    @Override
    @Value("${university.library.name}")
    public void setName(String name) {
        super.setName(name);
    }
}
