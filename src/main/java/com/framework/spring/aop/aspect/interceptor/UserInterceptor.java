package com.framework.spring.aop.aspect.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserInterceptor {

    @Pointcut("execution(* com.framework.spring.aop.aspect.service.UserServiceImpl.*(..))")
    private void anyMethod(){
        //定义一个切入点
    }

    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println(name);
        System.out.println("前置通知");
    }

    //@AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    //@After("anyMethod()")
    public void after(){
        System.out.println("最终通知");
    }

    //@AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }

    //@Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }
}
