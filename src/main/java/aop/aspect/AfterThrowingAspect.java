package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * выполняется после окончания метода с основной логикой только, если было выброшено исключение
 */
@Component
@Aspect
public class AfterThrowingAspect {
    @AfterThrowing(pointcut =
            "aop.poincut.Pointcuts.allSchoolLibraryMethods()" +
            " && aop.poincut.Pointcuts.allVoidMethods() " +
            "&& aop.poincut.Pointcuts.allReturnBookMethods()",
    throwing = "e")
    public void afterSchoolLibraryReturnBookThrows(JoinPoint joinPoint, Throwable e){
        System.out.println("Метод afterSchoolLibraryReturnBookThrows сработал после того, " +
                "как было брошено исключение в методе " + joinPoint.getSignature() + ". Это исключение " + e);
    }
}
