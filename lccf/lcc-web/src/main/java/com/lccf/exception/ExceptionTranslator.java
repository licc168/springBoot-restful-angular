package com.lccf.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lccf.service.security.UserNotActivatedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<String> loginException(Exception exception, HttpServletRequest request) {
        String exceptionMsg = getException(exception);
        HttpStatus status  = getStatus(request);
        return new ResponseEntity(exceptionMsg, status);
    }

    /**
     * 获取错误信息
     * @param exception
     * @return
     */

    private String getException(Exception exception) {
        if (exception instanceof UserNotActivatedException) {
            return ExceptionConst.USER_NOT_ACTIVATE;
        } else if (exception instanceof UsernameNotFoundException) {
            return ExceptionConst.USER_NOT_FOUND;
        } else {
            return ExceptionConst.SYS_EXCEPTION;
        }

    }

    /**
     * 获取错误编码
     * 
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
