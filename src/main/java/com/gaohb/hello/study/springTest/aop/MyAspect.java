package com.gaohb.hello.study.springTest.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.gaohb.hello.study.springTest.aop.AspectController.*(..))")
    private void onePointcut(){}

    @Before("onePointcut()")
    public void before(){
        System.out.println("-- before");
    }

    @After("onePointcut()")
    public void after(JoinPoint joinPoint) throws NoSuchMethodException{

//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//
//        /* 获取连接点方法的名字 */
//        String methodName = signature.getName();
//        System.out.println("连接点方法名：" + methodName);
//
//        Class[] parameterTypes = methodSignature.getParameterTypes(); // 参数类型列表
//        Object[] args = joinPoint.getArgs();  // 实际参数
//
//        /* 获取连接点目标对象实例 */
//        Object targetObj = joinPoint.getTarget(); // 实例
//        Method method1 = targetObj.getClass().getMethod(methodName,parameterTypes);
//        System.out.println(targetObj.getClass().getName());
//
//        /* 获取方法上的注解 */
//        ApiLog apiLog = method.getAnnotation(ApiLog.class);
//        if (apiLog != null && apiLog.isOn()){
//            System.out.println("After ApiLog is on！");
//            System.out.println("-- after --");
//        }

        System.out.println("-- after");
    }

    @Around("onePointcut()")
    public Object around(ProceedingJoinPoint point)throws Throwable{

        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        /* 获取方法上的注解 */
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        if (apiLog != null && apiLog.isOn()){
            System.out.println("ApiLog is on！");
        }

        Object[] objects = point.getArgs();
        String bussinessName = (String) objects[0];
        System.out.println("-- " + bussinessName + " start");
        long begin = System.currentTimeMillis();
        Object object = point.proceed();
        long end = System.currentTimeMillis();
        System.out.println("-- " + bussinessName + " end  耗时" + (end - begin) + "ms");

        return object;

    }

    @AfterThrowing("onePointcut()")
    public void afterThrowing(){
        System.out.println("-- afterThrowing");
    }

    @AfterReturning("onePointcut()")
    public void afterReturning(){
        System.out.println("-- afterReturning");
    }
}
