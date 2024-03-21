package com.y1forcode.aopdemo.aspect;

import com.y1forcode.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    //lets start with an @before advice

    //@Before("execution(public void com.y1forcode.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*(com.y1forcode.aopdemo.Account, ..))")
    //@Before("execution(* com.y1forcode..add(..))")


    // add a new advice for @AfterReturning on the findAccounts method

    @Around("execution(* com.y1forcode.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint
    ) throws Throwable {
        //print out method were advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n =======>>>Executing @Around on method: " + method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //now lets execute method
        Object result = theProceedingJoinPoint.proceed();
        //get end timestamp
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n ======> Duration: " + duration / 1000.0 + "seconds");


        return result;
    }


    @After("execution(* com.y1forcode.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n =======>>>Executing @After (finally) on method: " + method);
    }


    @AfterThrowing(
            pointcut = "execution(* com.y1forcode.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExc) {
        String method = theJointPoint.getSignature().toShortString();

        System.out.println("\n =======>>>Executing @AfterThrowing  on method: " + method);
        //print out the results of the method call
        System.out.println("\n =======>>> TheException is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.y1forcode.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        //print out which method we re advising on
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n =======>>> Executing @AfterRuning  on method()" + method);
        //print out the results of the method call
        System.out.println("\n =======>>> result is: " + result);


        //lets post process the data lets modify it

        //converts the account names uppercase
        convertAccountNamesToUpperCase(result);


        System.out.println("\n =======>>> result is: " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        //loop through accounts
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }


        //get the uppercase version

        //update the name
    }


    @Before("com.y1forcode.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n =======>>> Executing @Before Advice on updateAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        // display the method argument


        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);


            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }


    }


}
