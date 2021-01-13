package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    /**
     * Before Advice - выполняется до метода с основной логикой
     * В скобках execution указывается маска метода - это называется Pointcut
     */
    @Before("execution(public void getBook())")
    public void beforeGetBookAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookAdvice: попытка получить книгу");
    }

    /**
     * After Returning - выполняется только после нормального окончания метода с основной логикой
     */

    /**
     * After Throwing - выполняется после окончания метода с основной логико только, если было выброшено исключение
     */

    /**
     * After / After finally - выполняется после окончания метода с основной логикой
     */

    /**
     * Around - выполняется до и после основного метода
     */
}
