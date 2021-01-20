package aop.poincut;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    /**
     * Этот пойнткат выполнится для всех public void getBook() методов
     * Модификатор доступа - public
     * Тип возвращаемого значения - void
     * Имя метода - getBook
     * Параметры - без параметров
     */
    @Pointcut("execution(public void getBook())")
    public void allPublicVoidGetBookMethods(){}

    @Pointcut("execution(String return*())")
    public void stringReturnMethods(){}

    /**
     * Этот пойнткат затронет абсолютно все методы в классе UniversityLibrary
     */
    @Pointcut("execution(* model.impl.UniversityLibrary.*(..))")
    public void allUniversityLibraryMethods(){}

    /**
     * пойнткат затронет все void методы
     */
    @Pointcut("execution(void *(..))")
    public void allVoidMethods(){}
}
