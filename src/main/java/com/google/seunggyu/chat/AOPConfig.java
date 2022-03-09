package com.google.seunggyu.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
public class AOPConfig {
private static final Logger logger = LogManager.getLogger(AOPConfig.class);

@Around("within(com.google.seunggyu.chat.Controller..* )")
private Object getLog(ProceedingJoinPoint pjp)throws Throwable{

    Object request = getRequest();


    Object result = pjp.proceed();

    logger.info("----------------->Response :{}({}) = {}",pjp.getSignature().getDeclaringTypeName(),
            pjp.getSignature().getName(),result);

    return result;
}

    private String getRequest(){
    String params = "";

    RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();

    if(requestAttribute != null){

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getParameterMap().isEmpty())
            params = paramMapToString(request.getParameterMap());

    }

    return params;
}
    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s -> (%s)",
                        entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }

}
