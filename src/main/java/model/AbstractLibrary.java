package model;

import model.impl.Book;

public abstract class AbstractLibrary {
    private Book book;
    private String name;

    public void addBook(Book book) {
        this.book = book;
        System.out.println("Добавляю книгу под названием " + book.getName() + " в " + this.name);
    }

    public Book getBook(String name) {
        if (this.book.getName().compareToIgnoreCase(name) == 0) {
            System.out.println("Беру книгу под названием " + book.getName() + " из " + this.name);
            return this.book;
        } else {
            System.out.println("Книги с названием " + book.getName() + " нет в " + this.name + ". Есть книга с названием " + this.book.getName());
            return null;
        }
    }

    public void returnBook(Book book) {
        System.out.println("Вовзращаю книгу под названием " + book.getName() + " в " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
