package com.google.seunggyu.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApoConfig {
private static final Logger logger = LogManager.getLogger(ApoConfig.class);

@Around("within(com.google.seunggyu.chat..*)")
private Object getLog(ProceedingJoinPoint pjp)throws Throwable{

    Object result = pjp.proceed();

    logger.info("----------------->Response :{}({}) = {}",pjp.getSignature().getDeclaringTypeName(),
            pjp.getSignature().getName(),result);

    return result;
}

}
