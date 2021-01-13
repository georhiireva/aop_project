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
     * Пример с указанным declared type. Сработает только для метода getBook() из класса UniversityLibrary
     */
    @Before("execution(public void model.impl.UniversityLibrary.getBook())")
    public void beforeGetBookAdviceUniversityLibraryOnly() {
        System.out.println("LoggingAspect: Метод beforeGetBookAdviceUniversityLibraryOnly: попытка получить книгу");
    }

    /**
     * Сработает для всех public void методов, начинающихся на get
     */
    @Before("execution(public void get*())")
    public void beforeAllGetMethodsAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookAdviceUniversityLibraryOnly: попытка получить книгу");
    }

    /**
     * Сработает для всех методов, сигнатура которых [любой модификатор доступа] [любой возвращаемый тип] returnBook()
     */
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("LoggingAspect: Метод beforeReturnBookAdvice: попытка получить книгу");
    }

    /**
     * Сработает для всех методов юез параметров
     */
    @Before("execution(* *())")
    public void beforeAllMethodsWithoutParamsAdvice() {
        System.out.println("LoggingAspect: Метод beforeAllMethodsWithoutParamsAdvice: попытка получить книгу");
    }

    /**
     * Сработает для всех public void getBook с параметром String
     */
    @Before("execution(public void getBook(String))")
    public void beforeGetBookWithStringParamAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookWithStringParamAdvice: попытка получить книгу");
    }

    /**
     * Сработает для всех public void getBook с единственным параметром
     */
    @Before("execution(public void getBook(*))")
    public void beforeGetBookWithSingleParamAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookWithSingleParamAdvice: попытка получить книгу");
    }

    /**
     * Сработает для всех public void методов с единственным параметром
     */
    @Before("execution(public void *(*))")
    public void beforeAllMethodsWithSingleParamAdvice() {
        System.out.println("LoggingAspect: Метод beforeAllMethodsWithSingleParamAdvice: попытка получить книгу");
    }

    /**
     * Сработает для всех методов
     */
    @Before("execution(* *(..))")
    public void beforeAllMethodsAdvice() {
        System.out.println("LoggingAspect: Метод beforeAllMethodsAdvice: попытка получить книгу");
    }

    /**
     * Сработает для метода getBook(Book.class)
     */
    @Before("execution(* *(model.impl.Book))")
    public void beforeGetBookWithCustomParamAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookWithCustomParamAdvice: попытка получить книгу");
    }

    /**
     * Сработает для метода getBook(Book.class, + любое количество параметров)
     */
    @Before("execution(* *(model.impl.Book, ..))")
    public void beforeGetBookWithCustomParamAndAnyParamAdvice() {
        System.out.println("LoggingAspect: Метод beforeGetBookWithCustomParamAndAnyParamAdvice: попытка получить книгу");
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
