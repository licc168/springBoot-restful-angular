package com.lccf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;


/**
 * 参数验证处理类
 * @author lichangchao
 */
@Aspect
@Component
public class BindingResultAop {


    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.lccf..*.*(..))")
    public void aopMethod() {
    }


    @Around("aopMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("before method invoking!");
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof MethodArgumentNotValidException) {
                bindingResult =   ((MethodArgumentNotValidException) arg).getBindingResult();
            }
        }
        if (bindingResult != null) {
            if (bindingResult.hasErrors()) {
                String errorInfo = bindingResult.getFieldError().getDefaultMessage();
                return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return joinPoint.proceed();
    }
}