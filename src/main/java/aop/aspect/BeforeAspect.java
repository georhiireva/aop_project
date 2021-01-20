package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * выполняется до метода с основной логикой
 */
@Component
@Aspect
public class BeforeAspect {
    @Order(10)
    @Before("aop.poincut.Pointcuts.allUniversityLibraryMethods()")
    public void beforeAllUniversityLibraryMethods() {
        System.out.println("BeforeAdvice: перед каждым методом в классе UniversityLibrary");
    }

    @Order(20)
    @Before("aop.poincut.Pointcuts.allUniversityLibraryMethods() && aop.poincut.Pointcuts.allVoidMethods()")
    public void beforeAllVoidUniversityLibraryMethods() {
        System.out.println("BeforeAdvice: перед каждым void методом в классе UniversityLibrary");
    }

    @Before("aop.poincut.Pointcuts.allUniversityLibraryMethods() && !aop.poincut.Pointcuts.allVoidMethods()")
    @Order(20)
    public void beforeAllNonVoidUniversityLibraryMethods() {
        System.out.println("BeforeAdvice: перед каждым методом с возвращаемым значением в классе UniversityLibrary");
    }
}
