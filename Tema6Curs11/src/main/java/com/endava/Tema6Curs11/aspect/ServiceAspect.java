package com.endava.Tema6Curs11.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Pointcut("execution(* com.endava.Tema6Curs11.service.MovieService.*(..))")
    public void searchMethod1() {
    }

    @Pointcut("execution(* com.endava.Tema6Curs11.service.CastService.*(..))")
    public void searchMethod2() {
    }

    @Pointcut("execution(* com.endava.Tema6Curs11.service.GenreService.*(..))")
    public void searchMethod3() {
    }

    @Pointcut("searchMethod1() || searchMethod2() || searchMethod3()")
    public void searchMethods() {
    }

    @Before("searchMethods()")
    public void before(JoinPoint joinPoint) {
        System.out.print("Clasa: " + joinPoint.getSignature().getDeclaringTypeName() +
                " -> Metoda: " + joinPoint.getSignature().getName());
        Object[] signatureArgs = joinPoint.getArgs();
        if(signatureArgs.length != 0) {
            System.out.print(" -> Parametrii metodei: ");
            for(Object obj : signatureArgs) {
                System.out.print(obj.toString() + " ");
            }
        }
        System.out.println();
    }
}
