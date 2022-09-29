package com.example.SpringProjekat.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    @Pointcut("execution(* com.example.SpringProjekat.Kontroleri.*.*(..))")
    public void loggingPointcut() {

    }

    @Before("loggingPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before method invoked :" + joinPoint.getSignature());
    }

    @After("loggingPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After method invoked :" + joinPoint.getSignature());
    }

}
