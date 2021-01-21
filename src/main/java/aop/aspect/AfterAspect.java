package aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * (After finally) выполняется после окончания метода с основной логикой в любом случае -
 * было исключение или нет
 */
@Component
@Aspect
public class AfterAspect {
    @After("aop.poincut.Pointcuts.allCentralLibraryMethods()")
    public void allMethodsInCentralLibraryAfterAdvice() {
        System.out.println("AfterAdvice выполняется для всех методов в классе CentralLibrary");
    }
}
