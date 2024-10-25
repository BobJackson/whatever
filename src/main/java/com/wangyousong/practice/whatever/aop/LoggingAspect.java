package com.wangyousong.practice.whatever.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
        Object[] args = pjp.getArgs();
        String methodName = pjp.getSignature().getName();
        log.debug(">> {}() - {}", methodName, Arrays.toString(args));

        Object result = pjp.proceed();

        log.debug("<< {}() - {}", methodName, result);
        return result;
    }
}
