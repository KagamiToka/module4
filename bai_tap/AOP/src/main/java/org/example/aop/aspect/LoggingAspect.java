package org.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private int visitorCounter = 0;

    @Before("execution(* org.example.aop.controller..*(..))")
    public void countVisitor(JoinPoint joinPoint) {
        visitorCounter++;
        System.out.println("Người dùng #" + visitorCounter + " vừa ghé thăm: " + joinPoint.getSignature().getName());
    }
}
