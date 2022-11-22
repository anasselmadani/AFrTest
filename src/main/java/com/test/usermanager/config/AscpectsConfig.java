package com.test.usermanager.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AscpectsConfig {

    private Logger log = LoggerFactory.getLogger(AscpectsConfig.class);

    @Before("execution(*  com.test.usermanager.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        log.info("Start Executing {} ",joinPoint);
    }
    @Around("execution(* com.test.usermanager.controller.*.*(..))")
    public void trackingTime(ProceedingJoinPoint  joinPoint) {
        long startTime = System.currentTimeMillis();
        try {
            Object obj = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis()-startTime;
            log.info("Time taken for {} is {} ms",joinPoint,timeTaken);
         } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
