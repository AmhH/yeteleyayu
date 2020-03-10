package com.cognizant.studio.aspect;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Validator {

    private static final Log logger = LogFactory.getLog(Validator.class);

    @Pointcut("execution(* com.fasterxml.jackson.databind.*.*.wrapAndThrow(..)) && within(com.fasterxml.jackson.databind.deser.BeanDeserializerBase+)")
    private void anyOperation() { }

    @Around("anyOperation()")
    public Object suppress(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        }
        catch (InvalidFormatException e) {
            logger.error("caught an exception here");
            logger.error(e.getMessage());//TODO this would be converted to compile a list back to the calling method
        }
        return result;//continue
    }
}
