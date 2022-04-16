package com.softobt.testservice.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAnnotateClass {

    @Before("@annotation(com.softobt.testservice.aspect.TestAnnotate)")
    public void beforeAnnotateMethod(){
        System.out.println("before method");
    }

    @AfterReturning(pointcut = "@annotation(com.softobt.testservice.aspect.TestAnnotate)",returning = "object")
    private void afterAnnotateMethod(JoinPoint point,Object object){
        System.out.println("after method");
        System.out.println(new Gson().toJson(object));
    }
}
