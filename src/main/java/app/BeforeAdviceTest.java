package app;

import config.ApplicationContext;
import model.impl.Book;
import model.impl.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeAdviceTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationContext.class);

        if (true) {
            testBeforeAdvice(context);
        }

        context.close();
    }

    private static void testBeforeAdvice(AnnotationConfigApplicationContext context) {
        UniversityLibrary library = context.getBean(UniversityLibrary.class);
        Book book = context.getBean(Book.class);

        library.addBook(book);
        Book returnBook =  library.getBook("Преступление и наказание");

        if (returnBook != null) {
            library.returnBook(returnBook);
        }
    }
}
