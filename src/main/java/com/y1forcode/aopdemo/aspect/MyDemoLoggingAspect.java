package com.y1forcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    //lets start with an @before advice

    //@Before("execution(public void com.y1forcode.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    @Before("execution(* add*(com.y1forcode.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =======>>> Executing @Before Advice on updateAccount()" );
    }
}
