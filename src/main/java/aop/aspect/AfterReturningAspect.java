package aop.aspect;

import model.impl.Book;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * выполняется только после нормального окончания метода с основной логикой
 */
@Component
@Aspect
public class AfterReturningAspect {
    @AfterReturning(pointcut = "!aop.poincut.Pointcuts.allVoidMethods()", returning = "retVal")
    public Object changeReturningValueAfterReturnBookMethod(Object retVal) {
        if (retVal instanceof String) {
            return "Измененное значение";
        } else if (retVal instanceof Book) {
            Book book = (Book)retVal;
            book.setName("Измененное значение");
            return book;
        }
        return retVal;
    }
}
