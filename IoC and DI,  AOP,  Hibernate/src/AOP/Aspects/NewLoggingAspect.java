package AOP.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

//        long start = System.nanoTime();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            throw e;
//            targetMethodResult = "Неизвестное название книги";
        }
//        targetMethodResult = "Преступление и наказание";
//        long end = System.nanoTime();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
//        System.out.println("aroundReturnBookLoggingAdvice: метод returnBook выполнил работу за " +
//                (end - start) + " наносекунд");
        return targetMethodResult;
    }

}
