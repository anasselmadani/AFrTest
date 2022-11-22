package com.test.usermanager.config;

import com.test.usermanager.exceptions.UserException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class AscpectsConfig {

    private Logger log = LoggerFactory.getLogger(AscpectsConfig.class);

    @Before("execution(*  com.test.usermanager.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        log.info("Start Executing {} ",joinPoint);
    }


    @Around(value = "execution(* com.test.usermanager.services.*.*(..))")
    public Object userHandler(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            Object obj=joinPoint.proceed();
            return obj;
        }
        catch(UserException e) {
            log.info(" UserException StatusCode {}",e.getHttpStatus().value());
            log.info("Userxception Message {}",e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @Around("execution(* com.test.usermanager.controller.*.*(..))")
    public Object trackingTime(ProceedingJoinPoint  joinPoint ) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object obj = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis()-startTime;
            log.info("Time taken for {} is {} ms",joinPoint,timeTaken);
            return obj;
        } catch (UserException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
