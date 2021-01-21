package app;

import config.ApplicationContext;
import model.impl.Book;
import model.impl.CentralLibrary;
import model.impl.TownLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundAdviceTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationContext.class);

        if (true) {
            testAfterAdvice(context);
        }

        context.close();
    }

    private static void testAfterAdvice(AnnotationConfigApplicationContext context) {
        TownLibrary library = context.getBean(TownLibrary.class);
        Book book = context.getBean(Book.class);

        library.addBook(book);
        Book returnBook =  library.getBook("Преступление и наказание");

        if (returnBook != null) {
            try {
                library.returnBook(returnBook);
            } catch (IllegalStateException e) {
                System.out.println("Исключение поймано в MAIN классе");
            }
        }
    }
}
