package model.impl;

import model.AbstractLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TownLibrary extends AbstractLibrary {

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
        throw new IllegalStateException();
    }

    @Override
    @Value("${town.library.name}")
    public void setName(String name) {
        super.setName(name);
    }
}
