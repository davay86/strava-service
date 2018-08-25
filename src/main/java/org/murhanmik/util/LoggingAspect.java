package org.murhanmik.util;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class);

    @Around("execution(* org.murhanmik..*(..))")
    public Object logInput(ProceedingJoinPoint jointPoint) throws Throwable {
        logger.info("***** Entering: " + jointPoint.getTarget().getClass().getName());
        logger.info("***** Calling method: " + jointPoint.getSignature().getName());
        logger.info("***** With arguments: " + jointPoint.getArgs());

        Object returnValue = jointPoint.proceed();

        logger.info("***** Returning: " + returnValue);
        logger.info("***** From class: " + jointPoint.getTarget().getClass().getName());
        logger.info("***** From method: " + jointPoint.getSignature());

        return returnValue;
    }

}
