package model.impl;

import model.AbstractLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

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
        try{
            int a = 20 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение " + e);
            throw e;
        } finally {
            System.out.println("Сработал блок finally");
        }
    }

    @Override
    @Value("${school.library.name}")
    public void setName(String name) {
        super.setName(name);
    }
}
