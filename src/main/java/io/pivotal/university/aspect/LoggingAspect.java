package io.pivotal.university.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(io.pivotal.university.UniversityApplication.demo")

    public void logBeforeCreateStudent()
    {
        System.out.println("***************AOP********************" );
    }
}
