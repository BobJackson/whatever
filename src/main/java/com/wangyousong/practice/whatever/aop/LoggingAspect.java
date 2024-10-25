package com.wangyousong.practice.whatever.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(public * com.wangyousong.practice.whatever.aop.*.*(..))")
    private void publicMethod() {
    }

    @Around(value = "publicMethod()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = logMethodNameAndArguments(pjp);

        Object result = pjp.proceed();

        logMethodNameAndResult(result, methodName);
        return result;
    }

    @Before(value = "publicMethod()")
    public void logBefore(JoinPoint joinPoint) {
        logMethodNameAndArguments(joinPoint);
    }

    private static String logMethodNameAndArguments(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        log.debug(">> {}() - {}", methodName, Arrays.toString(args));
        return methodName;
    }

    @AfterReturning(value = "publicMethod()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logMethodNameAndResult(result, methodName);
    }

    private static void logMethodNameAndResult(Object result, String methodName) {
        log.debug("<< {}() - {}", methodName, result);
    }

    @AfterThrowing(value = "publicMethod()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception){
        String methodName = joinPoint.getSignature().getName();
        log.error("<< {}() - {}", methodName, exception.getMessage());
    }
}
