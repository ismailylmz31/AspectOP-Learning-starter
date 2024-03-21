package com.y1forcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.y1forcode.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {

    }

    //crate pointcut for getter setter

    @Pointcut("execution(* com.y1forcode.aopdemo.dao.*.get*(..))")
    public void getter(){}


    @Pointcut("execution(* com.y1forcode.aopdemo.dao.*.set*(..))")
    public void setter(){}


    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
