package aop.aspect;

import model.impl.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * выполняется только после нормального окончания метода с основной логикой
 */
@Component
@Aspect
/**
 * выполняется только после нормального окончания метода с основной логикой,
 * но до присвоения результата этого метода какой-либо переменной.
 * Поэтому с помощью @AfterReturning Advice возможно изменять возвращаемый результат метод
 */
public class AfterReturningAspect {
    @AfterReturning(
            pointcut = "aop.poincut.Pointcuts.allSchoolLibraryMethods() && !aop.poincut.Pointcuts.allVoidMethods()",
            returning = "retVal")
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

    @AfterReturning(value = "aop.poincut.Pointcuts.allPubicBookGetBookMethodsWithStringArgs() && ! aop.poincut.Pointcuts.allCentralLibraryMethods()")
    public void afterReturningGetBookMethod(JoinPoint joinPoint) {
        System.out.println("afterReturningGetBookMethod: демонстрация работы JoinPoint");
        System.out.println("afterReturningGetBookMethod: сигнатура метода: " + joinPoint.getSignature());
        System.out.println(
                "afterReturningGetBookMethod: аргументы метода: " +
                        Arrays.stream(joinPoint.getArgs()).reduce((x, y) -> x + ", " + y).get());
    }
}
