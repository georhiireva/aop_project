package app;

import config.ApplicationContext;
import model.Library;
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
        Library library = context.getBean(Library.class);
        library.getBook();
    }
}
