package app;

import config.ApplicationContext;
import model.impl.Book;
import model.impl.SchoolLibrary;
import model.impl.UniversityLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningAndAfterThrowingAdvicesTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationContext.class);

        if (true) {
            testAfterAdvice(context);
        }

        context.close();
    }

    private static void testAfterAdvice(AnnotationConfigApplicationContext context) {
        SchoolLibrary library = context.getBean(SchoolLibrary.class);
        Book book = context.getBean(Book.class);

        library.addBook(book);
        Book returnBook =  library.getBook("Преступление и наказание");

        if (returnBook != null) {
            try {
                library.returnBook(returnBook);
            } catch (ArithmeticException e) {
                System.out.println("Исключение поймано в MAIN классе");
            }
        }
    }
}
