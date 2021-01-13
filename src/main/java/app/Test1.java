package app;

import config.ApplicationContext;
import model.AbstractLibrary;
import model.impl.Book;
import model.impl.SchoolLibrary;
import model.impl.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationContext.class);

        if (true) {
            testAdviceBefore(context);
        }

        context.close();
    }

    private static void testAdviceBefore(AnnotationConfigApplicationContext context) {
        Book book = context.getBean(Book.class);
        UniversityLibrary universityLibrary = context.getBean(UniversityLibrary.class);
        universityLibrary.getBook();
        universityLibrary.returnBook();
        universityLibrary.getMagazine();
        universityLibrary.getBook("Преступление и наказание");
        universityLibrary.getBook(book);

        SchoolLibrary schoolLibrary = context.getBean(SchoolLibrary.class);
        schoolLibrary.getBook();
    }
}
