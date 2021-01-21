package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * выполняется до и после метода с основной логикой
 * Дает возможность:
 * 1. произвести действия до работы целевого метода
 * 2. произвести действия после работы целевого метода
 * 3. получить результат работы целевого метрода/изменить его
 * 4. предпринять действия, если из целевого метода выбрасывается исключение
 * Целевой метод должен быть вызван вручную из Advice'а
 *
 * Если не вернуть значение из AroundAdvice, то целевой метод не вернет никакого результата.
 * В данном примере я использовал один Advice с возвращаемым значением типа Object,
 * но он прекрасно работает и для void методов.
 */
@Component
@Aspect
public class AroundAspect {
    /**
     * Порядок в данном случае важен, так как второй Advice имеет тип возврата void
     * и, если второй Advice сработает перед первым, то метод getBook ничего не вернет,
     * поэтому не выполнится метод returnBook (проверка на null в классе
     * @see app.AroundAdviceTest)
     * @param proceedingJoinPoint
     * @return
     */
    @Around("aop.poincut.Pointcuts.allTownLibraryMethods()")
    @Order(1)
    public Object allMethodsInTownLibraryAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Работает AroundAdvice перед методом " + proceedingJoinPoint.getSignature());
        try{
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("AroundAdvice поймал исключение из метода " + proceedingJoinPoint.getSignature());
        }

        System.out.println("Работает AroundAdvice после метода " + proceedingJoinPoint.getSignature());
        return null;
    }

    @Around("aop.poincut.Pointcuts.allTownLibraryMethods()")
    @Order(2)
    public void allMethodsInTownLibraryAroundAdviceTimer(ProceedingJoinPoint proceedingJoinPoint) {
        Long begin = System.currentTimeMillis();
        try{
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("AroundAdvice поймал исключение из метода " + proceedingJoinPoint.getSignature());
        }
        Long end = System.currentTimeMillis();
        System.out.println("Метод " + proceedingJoinPoint.getSignature() + " выполнялся " + (end-begin) + " миллисекунд");
    }
}
